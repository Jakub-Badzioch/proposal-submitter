package com.towerbuilder.proposalsubmitter.model.dto;

import com.towerbuilder.proposalsubmitter.model.Status;
import com.towerbuilder.proposalsubmitter.model.TripReason;
import com.towerbuilder.proposalsubmitter.model.TripType;
import com.towerbuilder.proposalsubmitter.validator.LastDayIsAfterFirstDay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@LastDayIsAfterFirstDay
public class ProposalDTO extends BasicDTO {
    private TripType tripType;
    private TripReason tripReason;
    @FutureOrPresent
    private LocalDate firstDay;
    @Future
    private LocalDate lastDay;
    private String country;
    private String city;
    private Boolean isTripWithAccommodation;
    private Status status;
    private BigDecimal price;
}