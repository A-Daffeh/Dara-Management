package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.event.CompleteRegistrationEvent;
import com.icops.DaraManagement.model.PasswordResetToken;
import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.VerificationToken;
import com.icops.DaraManagement.model.entity.PasswordModel;
import com.icops.DaraManagement.model.entity.UserModel;
import com.icops.DaraManagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new CompleteRegistrationEvent(user, applicationUrl(request)));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid"))
            return "User Verified Successfully";
        return "Bad User";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordModel passwordModel, HttpServletRequest httpServletRequest) {
        User user = userService.findUserByEmail(passwordModel.getEmail());
        String url = "";
        if (user != null) {
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);
            url = passwordResetTokenMail(user, applicationUrl(httpServletRequest), token);
        }
        return url;
    }

//    @PostMapping("/savePassword")
//    public String savePassword(@RequestParam("token") String token, @RequestBody PasswordModel passwordModel) {
//        String result = userService.validatePasswordToken(token);
//
//        if (!result.equalsIgnoreCase("valid")) {
//            return "Invalid Token";
//        }
//        Optional<User> user = userService.getUserByPasswordResetToken(token);
//        if (user.isPresent()) {
//            return "Password Reset Successfully";
//        }  else {
//            return "Invalid Token";
//        }
//    }

    private String passwordResetTokenMail(User user, String applicationUrl, String token) {
        String url = applicationUrl+ "/savePassword?token=" + token;

        log.info("Click link to reset your password: {}", url);
        return "";
    }


    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken, HttpServletRequest request) {
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
        User user = verificationToken.getUser();
        resendVerificationTokenMail(user, applicationUrl(request), verificationToken);
        return "Verification Link Sent";
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {
        String url = applicationUrl+ "/verifyRegistration?token=" + verificationToken.getToken();

        log.info("Click link to verify your account: {}", url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
