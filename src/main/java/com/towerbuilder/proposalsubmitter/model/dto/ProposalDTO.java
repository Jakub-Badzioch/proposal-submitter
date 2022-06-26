package com.towerbuilder.proposalsubmitter.model.dto;
import com.towerbuilder.proposalsubmitter.model.TripReason;
import com.towerbuilder.proposalsubmitter.model.TripType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDTO extends BasicDTO  {
      private Long id;
      private Long employeeId;
      private Long hotelId;
      private LocalDate firstDay;
      private LocalDate lastDay;
      private TripType tripType;
      private TripReason tripReason;
      private String country;
      private String city;
      private Boolean isTripWithAccommodation;
      private BigDecimal price;
}