package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.model.Parent;
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
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping("/parents")
    public String allParents(Model model) {
        List<Parent> parents = parentService.allParents();
        model.addAttribute("parents", parents);
        return "parents/index";

    }

    @GetMapping("addParent")
    public String addParent(Model model) {
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "parents/create";
    }

    @PostMapping("/newParent")
    public String createParent(@ModelAttribute Parent parent) {
        parentService.create(parent);
        return "redirect:/parents";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@RequestBody Parent parent, @PathVariable Long id){

        Parent updatedParent = parentService.updateParent(parent, id);
        return new ResponseEntity<>(updatedParent, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable("id") Long id) {
        Parent parent = parentService.findById(id);
        if (parent != null) {
            return new ResponseEntity<>(parent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
