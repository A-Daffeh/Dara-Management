package com.icops.DaraManagement.service;

import com.icops.DaraManagement.model.Parent;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.Gender;

import java.util.List;

public interface ParentService {

    Parent create(final Parent parent);
    List<Parent> allParents();

    Parent findById(Long id);

    List<Parent> findByStudent(Long id);

    Long findStudentIdByLastname(String lastName);

    List<Parent> findByGender(Gender gender);

    Parent updateParent(Parent parent, Long id);

    void deleteParent(Long id);
}
