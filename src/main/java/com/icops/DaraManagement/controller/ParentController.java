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

import java.util.List;

@Controller
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping("")
    public String allParents(Model model) {
        List<Parent> parents = parentService.allParents();
        model.addAttribute("parents", parents);
        return "parents/index";

    }

    @GetMapping("/add")
    public String addParent(Model model) {
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "parents/create";
    }

    @PostMapping("/new")
    public String createParent(@ModelAttribute Parent parent) {
        parentService.create(parent);
        return "redirect:/parents";
    }

    @GetMapping("/edit/{id}")
    public String editCountry(@PathVariable(value = "id") long id, Model model) {
        Parent parent = getParentById(id);
        model.addAttribute("parent", parent);
        return "parents/edit";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@RequestBody Parent parent, @PathVariable Long id){

        Parent updatedParent = parentService.updateParent(parent, id);
        return new ResponseEntity<>(updatedParent, HttpStatus.OK);

    }

    @GetMapping("/{id}")
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
