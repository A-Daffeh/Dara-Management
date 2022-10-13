package com.icops.DaraManagement.model;

import com.icops.DaraManagement.model.enums.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class PersonDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Valid @NotNull
    private String firstName;
    private String middleName;
    @Valid @NotNull
    private String lastName;
    private Gender gender;
    @Valid @Pattern(regexp = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$", message = "Invalid phone number. It must be in the format XXX-XXX-XXXX")
    private String primaryPhone;
    @Valid
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

}
