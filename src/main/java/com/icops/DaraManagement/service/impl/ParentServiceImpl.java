package com.icops.DaraManagement.service.impl;

import com.icops.DaraManagement.model.Parent;
import com.icops.DaraManagement.repository.ParentDao;
import com.icops.DaraManagement.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentDao parentDao;

    public Parent create(final Parent parent) {
        return parentDao.save(parent);
    }
}
