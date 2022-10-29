package com.icops.DaraManagement.model.entity;

import com.icops.DaraManagement.model.PersonDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends PersonDetails {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Password should have at least 8 characters")
    @Column(length = 60)
    private String password;
    private String matchingPassword;
}
