package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class ProposalEntity extends AbstractEntity {
    private LocalDate firstDay;
    private LocalDate lastDay;
    @Enumerated(EnumType.STRING)
    private TripType tripType;
    private String country;
    private String city;
    private Boolean isTripWithAccommodation;
}
