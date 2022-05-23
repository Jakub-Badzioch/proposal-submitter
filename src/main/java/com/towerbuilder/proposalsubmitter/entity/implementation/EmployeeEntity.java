package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.Grade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class EmployeeEntity extends AbstractEntity {
    @OneToMany(mappedBy = "employee")
    private List<ProposalEntity> proposals;
    private String email;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    @Column(length=1, nullable=false)
    private Grade grade;
    private String country;
}
