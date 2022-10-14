package com.icops.DaraManagement.service;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.model.enums.RecitationLevel;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    List<Student> allStudents();

    Student findById(Long id);

    List<Student> findByGender(Gender gender);

    List<Student> findStudentByRecitationLevel(RecitationLevel recitationLevel);

    List<Student> findByAttendanceMode(AttendanceMode attendanceMode);



}
