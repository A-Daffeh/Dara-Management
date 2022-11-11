package com.icops.DaraManagement.controller;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String allStudents(Model model) {
        List<Student> students = studentService.allStudents();
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "students/create";
    }

    @PostMapping("/students/create")
    public String createStudent(@ModelAttribute("student")  @Valid Student student) {

        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable(value = "id") long id, Model model) {
        Student student = getStudent(id);
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student) {
        studentService.create(student);
        return "redirect:/students";
    }
    @GetMapping("/showStudent/{id}")
    public String viewStudent(@PathVariable(value = "id") long id, Model model) {
        Student student = getStudent(id);
        model.addAttribute("student", student);
        return "/students/show";
    }

    @GetMapping("/studentByGender/{gender}")
    public ResponseEntity<List<Student>> getStudentByGender(@PathVariable("gender")Gender gender) {
        List<Student> students = studentService.findByGender(gender);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/studentRecitationLevel/{recitationLevel}")
    public ResponseEntity<List<Student>> getStudentByRecitationLevel(@PathVariable("recitationLevel")RecitationLevel recitationLevel) {
        List<Student> students = studentService.findStudentByRecitationLevel(recitationLevel);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/studentAttendanceMode/{attendanceMode}")
    public ResponseEntity<List<Student>> getStudentByAttendanceMode(@PathVariable("attendanceMode")AttendanceMode attendanceMode) {
        List<Student> students = studentService.findByAttendanceMode(attendanceMode);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id")Long id) {
        Student student = studentService.findById(id);
        return student;
    }



}
