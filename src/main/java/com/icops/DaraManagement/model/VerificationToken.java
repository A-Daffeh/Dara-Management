package com.icops.DaraManagement.model;

import antlr.Token;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
    private static final int EXPIRATION_TIME = 15;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(User user, String token) {
        this.user = user;
        this.token = token;
        expirationTime = calculateExpirationTime(EXPIRATION_TIME);
    }

    public VerificationToken(String token) {
        super();
        this.token = token;
        expirationTime = calculateExpirationTime(EXPIRATION_TIME);
    }

    private Date calculateExpirationTime(int expiration_time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expiration_time);

        return new Date(calendar.getTime().getTime());
    }
}
