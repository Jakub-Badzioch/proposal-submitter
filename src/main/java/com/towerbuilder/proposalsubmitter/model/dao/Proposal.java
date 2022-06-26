package com.towerbuilder.proposalsubmitter.model.dao;

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
import java.util.Objects;

@Entity
@SuperBuilder
@ToString(callSuper=true)
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
    private Boolean isAccepted;
    private BigDecimal price;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (! super.equals(obj)) return false;
        Proposal proposal = (Proposal) obj;
        return Objects.equals(getEmployee(), proposal.getEmployee())
                && Objects.equals(getHotel(), proposal.getHotel())
                && getTripType() == proposal.getTripType()
                && getTripReason() == proposal.getTripReason()
                && Objects.equals(getFirstDay(), proposal.getFirstDay())
                && Objects.equals(getLastDay(), proposal.getLastDay())
                && Objects.equals(getCountry(), proposal.getCountry())
                && Objects.equals(getCity(), proposal.getCity())
                && Objects.equals(getIsTripWithAccommodation(), proposal.getIsTripWithAccommodation())
                && Objects.equals(getIsAccepted(), proposal.getIsAccepted())
                && Objects.equals(getPrice(), proposal.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmployee(), getHotel(), getTripType(),
                getTripReason(), getFirstDay(), getLastDay(), getCountry(), getCity(),
                getIsTripWithAccommodation(), getIsAccepted(), getPrice());
    }
}
