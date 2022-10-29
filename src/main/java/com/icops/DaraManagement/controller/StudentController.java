package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.model.PersonDetails;
import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import com.icops.DaraManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/admin")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @RequestMapping("/students")
    public String allStudents(Model model) {
        List<Student> students = studentService.allStudents();
        model.addAttribute("students", students);
        return "/admin/student/index";
    }

    @GetMapping("/newStudent")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "/admin/student/create";
    }

    @PostMapping("/addStudent")
    public String createStudent(@ModelAttribute Student student) {
        studentService.create(student);
        return "redirect:/admin/students";
    }

    @GetMapping("/genders/{gender}")
    public ResponseEntity<List<Student>> getStudentByGender(@PathVariable("gender")Gender gender) {
        List<Student> students = studentService.findByGender(gender);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/recitations/{recitationLevel}")
    public ResponseEntity<List<Student>> getStudentByRecitationLevel(@PathVariable("recitationLevel")RecitationLevel recitationLevel) {
        List<Student> students = studentService.findStudentByRecitationLevel(recitationLevel);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/attendance/{attendanceMode}")
    public ResponseEntity<List<Student>> getStudentByAttendanceMode(@PathVariable("attendanceMode")AttendanceMode attendanceMode) {
        List<Student> students = studentService.findByAttendanceMode(attendanceMode);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
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
