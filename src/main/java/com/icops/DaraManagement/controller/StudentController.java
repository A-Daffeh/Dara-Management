package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import com.icops.DaraManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> allStudents() {
        List<Student> students = studentService.allStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.create(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{recitationLevel}")
    public ResponseEntity<List<Student>> getStudentByRecitationLevel(@PathVariable("recitationLevel")RecitationLevel recitationLevel) {
        List<Student> students = studentService.findStudentByRecitationLevel(recitationLevel);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{attendanceMode}")
    public ResponseEntity<List<Student>> getStudentByAttendanceMode(@PathVariable("attendanceMode")AttendanceMode attendanceMode) {
        List<Student> students = studentService.findByAttendanceMode(attendanceMode);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id")Long id) {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student newStudent = studentService.create(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }
}
