package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.Grade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class EmployeeEntity extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    @Column(length=1, nullable=false)
    private Grade grade;
    private String country;
}
