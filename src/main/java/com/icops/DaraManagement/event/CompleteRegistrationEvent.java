package com.icops.DaraManagement.event;

import com.icops.DaraManagement.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CompleteRegistrationEvent extends ApplicationEvent {

    private User user;
    private String appUrl;

    public CompleteRegistrationEvent(User user, String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }
}
