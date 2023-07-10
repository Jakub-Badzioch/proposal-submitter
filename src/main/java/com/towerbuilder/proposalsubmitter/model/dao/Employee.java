package com.towerbuilder.proposalsubmitter.model.dao;

import com.towerbuilder.proposalsubmitter.model.Grade;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

// Clasterd i NonClaastered index czyli unikalny/nie. Chodzi o unikalonosc danych w kolumnach dla danego indexu
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "idx_email", columnList = "email", unique = true),
})
public class Employee extends Basic {
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Proposal> proposals;
    @ManyToOne
    private CompanyBranch companyBranch;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String telephoneNumber;
    private String country;
}
