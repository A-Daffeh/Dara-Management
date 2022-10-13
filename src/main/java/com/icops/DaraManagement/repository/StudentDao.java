package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, User> {
    List<Student> findByRecitationLevel(RecitationLevel recitationLevel);
    List<Student> findByAttendanceMode(AttendanceMode attendanceMode);
}
