package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDao extends JpaRepository<Student, User> {

    Optional<Student> findById(Long id);
    List<Student> findByGender(Gender gender);
    List<Student> findByRecitationLevel(RecitationLevel recitationLevel);
    List<Student> findByAttendanceMode(AttendanceMode attendanceMode);



}
