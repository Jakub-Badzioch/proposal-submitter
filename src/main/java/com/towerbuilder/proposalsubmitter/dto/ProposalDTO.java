package com.towerbuilder.proposalsubmitter.dto;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripReason;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class ProposalDTO {
      private Long employeeId;
      private LocalDate firstDay;
      private LocalDate lastDay;
      private TripType tripType;
      private TripReason tripReason;
      private String country;
      private String city;
      private Boolean isTripWithAccommodation;
      private BigDecimal price;
}