package com.towerbuilder.proposalsubmitter.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import com.towerbuilder.proposalsubmitter.model.Grade;
import com.towerbuilder.proposalsubmitter.validator.group.Create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
// @NotBlank tylko do stringow
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO extends BasicDTO {
    @NotNull
    private Grade grade;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Past
    private LocalDate birthDate;
    @NotBlank
    private String email;
    @NotBlank(message = "Incorrect password. Can't be null and length with/without whitespaces must be longer than 0.", groups = Create.class)
    @Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])).{10,}",
            message = "Incorrect password. Must be at least: 1 int, 1 lowercase, 1 uppercase, 10 chars.", groups = Create.class)
    private String password;
    @Length(min = 9, max = 9)
    private String telephoneNumber;
    @NotBlank
    private String country;
}
