package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.entity.enumeration.Grade;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripReason;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;
import com.towerbuilder.proposalsubmitter.entity.implementation.EmployeeEntity;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import com.towerbuilder.proposalsubmitter.repository.ProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProposalServiceTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private EmployeeRepository employeeRepository;

    private ProposalDTO proposalDTO;

    @BeforeEach
    void setUp() {
       proposalDTO = ProposalDTO.builder()
                .employeeId(0L)
                .firstDay(LocalDate.of(2022, 11, 1))
                .lastDay(LocalDate.of(2022, 11, 18))
                .tripType(TripType.PAID_BY_THE_COMPANY)
                .tripReason(TripReason.TRAINING)
                .country("USA")
                .city("Honolulu")
                .isTripWithAccommodation(true)
                .price(BigDecimal.valueOf(14000))
                .build();
    }

    @Test
    void shouldCreateAndAcceptProposal() {
        proposalService.createProposal(proposalDTO);
    }
}
