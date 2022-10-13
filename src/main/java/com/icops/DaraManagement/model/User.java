package com.icops.DaraManagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
//@DiscriminatorValue("users")
@Entity
public class User extends PersonDetails {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @OneToOne(cascade = CascadeType.ALL)
//    private PersonDetails personDetails;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;
}
