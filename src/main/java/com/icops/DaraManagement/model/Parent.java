package com.icops.DaraManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Slf4j
public class Parent extends PersonDetails{
    @Valid
    @Email
    private String email;

    @ManyToMany(mappedBy = "parents")
    private List<Student> kids;
}
