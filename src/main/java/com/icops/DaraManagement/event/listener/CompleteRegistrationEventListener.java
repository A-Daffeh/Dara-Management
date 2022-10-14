package com.icops.DaraManagement.event.listener;

import com.icops.DaraManagement.event.CompleteRegistrationEvent;
import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class CompleteRegistrationEventListener implements ApplicationListener<CompleteRegistrationEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(CompleteRegistrationEvent event) {
        // TODO: Create the verificatio token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // TODO: Send mail to user
        String url = event.getAppUrl() + "/verify?token=" + token;

        log.info("Click link to verify your account: {}", url);
    }
}
