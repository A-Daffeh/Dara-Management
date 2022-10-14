package com.icops.DaraManagement.service.impl;

import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.VerificationToken;
import com.icops.DaraManagement.model.entity.UserModel;
import com.icops.DaraManagement.repository.UserDao;
import com.icops.DaraManagement.repository.VerificationTokenDao;
import com.icops.DaraManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private VerificationTokenDao verificationTokenDao;

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
}
