package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.model.Parent;
import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ParentController {

    @Autowired
    private ParentService parentService;
    @Autowired
    private StudentController studentController;

    @GetMapping("/parents")
    public String allParents(Model model) {
        List<Parent> parents = parentService.allParents();
        model.addAttribute("parents", parents);
        return "parents/index";

    }

    @GetMapping("/parents/add")
    public String addParent(Model model,@ModelAttribute("fullName") String fullName, @ModelAttribute ("studentId") Long studentId) {

        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        model.addAttribute("studentId", studentId);
        model.addAttribute("fullName", fullName);
        return "parents/create";
    }

    @PostMapping("parents/create")
    public String createParent(Model model, @ModelAttribute Parent parent) {
        parentService.create(parent);
        model.getAttribute("studentId");
        model.getAttribute("fullName");
        return "redirect:/parents";
    }

    @GetMapping("/editParent/{id}")
    public String editCountry(@PathVariable(value = "id") long id, Model model) {
        Parent parent = getParentById(id);
        model.addAttribute("parent", parent);
        return "parents/edit";
    }

    @PostMapping("/updateParent/{id}")
    public String updateParent(@PathVariable("id") long id, @Valid Parent parent) {
        parentService.create(parent);
        return "redirect:/parents";
    }

    @GetMapping("/showParent/{id}")
    public String viewParent(@PathVariable(value = "id") long id, Model model) {
        Parent parent = getParentById(id);
        model.addAttribute("parent", parent);
        return "/parents/show";
    }

    @GetMapping("/parent/{id}")
    public Parent getParentById(@PathVariable("id") Long id) {
        Parent parent = parentService.findById(id);
        return parent;
    }

    @GetMapping("/{gender}")
    public ResponseEntity<List<Parent>> getParentByGender(@PathVariable("gender") Gender gender) {
        List<Parent> parents = parentService.findByGender(gender);
        if (parents != null) {
            return new ResponseEntity<>(parents, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<List<Parent>> getParentByStudent(@PathVariable("lastName") String lastName) {
        Long st = parentService.findStudentIdByLastname(lastName);
        if (st == null)
        { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        else
        {List<Parent> parents = parentService.findByStudent(st);
        if (parents != null) {
            return new ResponseEntity<>(parents, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }
}
