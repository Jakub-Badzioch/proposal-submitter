package com.towerbuilder.proposalsubmitter.mapper;

import com.towerbuilder.proposalsubmitter.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.entity.implementation.ProposalEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProposalMapper {
    public static ProposalEntity toEntity(ProposalDTO proposalDTO) {
        return ProposalEntity.builder()
                .firstDay(proposalDTO.getFirstDay())
                .lastDay(proposalDTO.getLastDay())
                .tripType(proposalDTO.getTripType())
                .tripReason(proposalDTO.getTripReason())
                .country(proposalDTO.getCountry())
                .city(proposalDTO.getCity())
                .isTripWithAccommodation(proposalDTO.getIsTripWithAccommodation())
                .price(proposalDTO.getPrice())
                .build();
    }
}
