package com.towerbuilder.proposalsubmitter.model.dto;

import com.towerbuilder.proposalsubmitter.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO extends BasicDTO {
    private Grade grade;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    // rzuca  methodargumentnotvalidexception
    @NotBlank(message = "Incorrect password. Can't be null and length with/without whitespaces must be longer than 0.")
    @Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])).{10,}",
            message = "Incorrect password. Must be at least: 1 int, 1 lowercase, 1 uppercase, 10 chars.")
    private String password;
    private String telephoneNumber;
    private String country;
}
