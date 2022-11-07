package com.icops.DaraManagement.service;


import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.VerificationToken;
import com.icops.DaraManagement.model.entity.UserModel;

import java.util.Optional;

public interface UserService {

    User create(User user);

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

//    String validatePasswordToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);
}
