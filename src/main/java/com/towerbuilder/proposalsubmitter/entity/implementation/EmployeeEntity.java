package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.Grade;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity(name = "employee")
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, columnDefinition="ENUM(\"A\", \"B\", \"C\", \"D\", \"E\", \"F\")")
    private Grade grade;

    @OneToMany(mappedBy = "employee")
    private List<ProposalEntity> proposals;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String telephoneNumber;
    private String country;
}
