package com.towerbuilder.proposalsubmitter.model.dao;

import com.towerbuilder.proposalsubmitter.model.Status;
import com.towerbuilder.proposalsubmitter.model.TripReason;
import com.towerbuilder.proposalsubmitter.model.TripType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proposal extends Basic {
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    private TripType tripType;
    @Enumerated(EnumType.STRING)
    private TripReason tripReason;
    private LocalDate firstDay;
    private LocalDate lastDay;
    private String country;
    private String city;
    private Boolean isTripWithAccommodation;
    private Status status;
    private BigDecimal price;
}
