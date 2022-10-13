package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.model.Parent;
import com.icops.DaraManagement.repository.ParentDao;
import com.icops.DaraManagement.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/create-parent")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent newParent = parentService.create(parent);
        return new ResponseEntity<>(newParent, HttpStatus.CREATED);
    }
}
