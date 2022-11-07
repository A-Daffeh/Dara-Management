package com.icops.DaraManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordModel {
    private String email;
    private String oldPassword;
    private String newPassword;
}
