package com.icops.DaraManagement.service;


import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.entity.UserModel;
import com.icops.DaraManagement.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    User create(User user);

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
