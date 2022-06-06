package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripReason;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Entity(name = "proposal")
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalEntity extends AbstractEntity {

    @ManyToOne
    private EmployeeEntity employee;

    @ManyToOne
    private HotelEntity hotel;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, columnDefinition="ENUM(\"PAID_BY_THE_COMPANY\", \"PAID_BY_THE_CLIENT\")")
    private TripType tripType;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, columnDefinition="ENUM(\"VISIT_TO_THE_CLIENT\", \"TRAINING\", \"MARKETING\")")
    private TripReason tripReason;

    private LocalDate firstDay;
    private LocalDate lastDay;
    private String country;
    private String city;
    private Boolean isTripWithAccommodation;
    private Boolean isAccepted;
    private BigDecimal price;
}
