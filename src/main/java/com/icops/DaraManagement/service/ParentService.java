package com.icops.DaraManagement.service;

import com.icops.DaraManagement.model.Parent;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.repository.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentDao parentDao;

    public Parent create(final Parent parent) {
        return parentDao.save(parent);
    }

    public List<Parent> allParents() {
        return parentDao.findAll();
    }

    public Parent findById(Long id) {
        Parent parent = parentDao.findById(id).orElse(null);
        return parent;
    }

    public List<Parent> findByStudent(Long id) {
       return  parentDao.findByStudent(id);
    }

    public Long findStudentIdByLastname(String lastName){
         Long st= parentDao.findStudentIdByLastname(lastName);
        return st;
    }
    public List<Parent> findByGender(Gender gender) {return parentDao.findByGender(gender);}
    public Parent updateParent(Parent parent, Long id)
    {

        Parent updatedParent = parentDao.save(parent);
        return updatedParent;
    }

    public void deleteParent(Long id){
        parentDao.deleteById(id);
    }
}
