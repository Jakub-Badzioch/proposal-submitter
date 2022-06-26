package com.towerbuilder.proposalsubmitter.model.dao;

import com.towerbuilder.proposalsubmitter.model.Grade;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@SuperBuilder
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Basic {

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToMany(mappedBy = "employee")
    // nie musze dodawac tego z drugiej strony. nie zapetli sie i tak
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Proposal> proposals;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String telephoneNumber;
    private String country;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Employee employee = (Employee) obj;
        return getGrade() == employee.getGrade()
                && Objects.equals(getProposals(), employee.getProposals())
                && Objects.equals(getFirstName(), employee.getFirstName())
                && Objects.equals(getLastName(), employee.getLastName())
                && Objects.equals(getBirthDate(), employee.getBirthDate())
                && Objects.equals(getEmail(), employee.getEmail())
                && Objects.equals(getPassword(), employee.getPassword())
                && Objects.equals(getTelephoneNumber(), employee.getTelephoneNumber())
                && Objects.equals(getCountry(), employee.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGrade(), getProposals(), getFirstName(), getLastName(),
                getBirthDate(), getEmail(), getPassword(), getTelephoneNumber(), getCountry());
    }
}
