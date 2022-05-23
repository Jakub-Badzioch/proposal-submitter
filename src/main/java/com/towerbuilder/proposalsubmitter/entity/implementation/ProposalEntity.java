package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalEntity extends AbstractEntity {
    @ManyToOne
    private EmployeeEntity employee;
    private LocalDate firstDay;
    private LocalDate lastDay;
    @Enumerated(EnumType.STRING)
    private TripType tripType;
    private String country;
    private String city;
    private Boolean isTripWithAccommodation;
    private Boolean isAccepted;
}
