package com.icops.DaraManagement.service;

import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User create(User user) {
        return userDao.save(user);
    }
}
