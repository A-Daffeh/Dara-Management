package com.icops.DaraManagement.service;

import com.icops.DaraManagement.model.Parent;
import com.icops.DaraManagement.repository.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    @Autowired
    private ParentDao parentDao;

    public Parent create(final Parent parent) {
        return parentDao.save(parent);
    }
}
