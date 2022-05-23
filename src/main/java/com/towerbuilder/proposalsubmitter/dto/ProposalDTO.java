package com.towerbuilder.proposalsubmitter.dto;

import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProposalDTO {
    private Long employeeId;
    private LocalDate firstDay;
    private LocalDate lastDay;
    private TripType tripType;
    private String country;
    private String city;
    private Boolean isTripWithAccommodation;
}
