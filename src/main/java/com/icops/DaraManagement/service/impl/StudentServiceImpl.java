package com.icops.DaraManagement.service.impl;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import com.icops.DaraManagement.repository.StudentDao;
import com.icops.DaraManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    public Student create(Student student) {
        return studentDao.save(student);
    }

    public List<Student> allStudents() {
        return studentDao.findAll();
    }

    public Student findById(Long id) {
        Student student = studentDao.findById(id).orElse(null);
        return student;
    }

    public List<Student> findByGender(Gender gender) {
        return studentDao.findByGender(gender);
    }

    public List<Student> findStudentByRecitationLevel(RecitationLevel recitationLevel) {
        return studentDao.findByRecitationLevel(recitationLevel);
    }

    public List<Student> findByAttendanceMode(AttendanceMode attendanceMode) {
        return studentDao.findByAttendanceMode(attendanceMode);
    }
}
