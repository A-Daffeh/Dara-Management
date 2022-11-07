package com.icops.DaraManagement.service.impl;

import com.icops.DaraManagement.model.PasswordResetToken;
import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.VerificationToken;
import com.icops.DaraManagement.model.entity.UserModel;
import com.icops.DaraManagement.repository.PasswordResetDao;
import com.icops.DaraManagement.repository.UserDao;
import com.icops.DaraManagement.repository.VerificationTokenDao;
import com.icops.DaraManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private VerificationTokenDao verificationTokenDao;

    @Autowired
    private PasswordResetDao passwordResetDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(User user) {
        return userDao.save(user);
    }

    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setMiddleName(userModel.getMiddleName());
        user.setLastName(userModel.getLastName());
        user.setGender(userModel.getGender());
        user.setPrimaryPhone(userModel.getPrimaryPhone());
        user.setAddress(userModel.getAddress());
        user.setEmail(userModel.getEmail());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole("USER");

        userDao.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenDao.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenDao.findByToken(token);
        if (verificationToken == null)
            return "invalid";
        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if ((verificationToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
            verificationTokenDao.delete(verificationToken);
            return "expired";
        }

        user.setEnabled(true);
        userDao.save(user);
        return "valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken = verificationTokenDao.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenDao.save(verificationToken);
        return verificationToken;
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(user, token);
        passwordResetDao.save(passwordResetToken);
    }

//    @Override
//    public String validatePasswordToken(String token) {
//        PasswordResetToken passwordToken = PasswordResetDao.findByToken();
//        if (passwordToken == null)
//            return "invalid";
//        User user = passwordToken.getUser();
//        Calendar cal = Calendar.getInstance();
//
//        if ((passwordToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
//            passwordResetDao.delete(passwordToken);
//            return "expired";
//        }
//        return "valid";
//    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResetDao.findByToken(token).getUser());
    }
}
