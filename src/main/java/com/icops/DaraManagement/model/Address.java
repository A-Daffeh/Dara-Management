package com.icops.DaraManagement.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String addressLine1;
    private String addressLine2;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9][A-Za-z0-9]*$")
    private String city;
    @NotNull
    private String state;
    @NotNull
    @Pattern(regexp = "^\\d{5}$", message = "Postal code should be 5 digits")
    private String postalCode;
}
