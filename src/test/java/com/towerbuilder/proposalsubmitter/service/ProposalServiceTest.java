package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.entity.enumeration.Grade;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripType;
import com.towerbuilder.proposalsubmitter.entity.implementation.EmployeeEntity;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProposalServiceTest {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private EmployeeRepository employeeRepository;

    private ProposalDTO proposalDTO;


    @BeforeEach
    void setUp() {
        final EmployeeEntity employee = new EmployeeEntity();
        employee.setEmail("bodziov3@gmail.com");
        employee.setFirstName("Jacob");
        employee.setTelephoneNumber("512587425");
        employee.setBirthDate(LocalDate.of(1999, 12, 2));
        employee.setGrade(Grade.F);
        employee.setCountry("USA");
        employeeRepository.save(employee);
        final EmployeeEntity entity = employeeRepository.findByEmail(employee.getEmail()).get();
        proposalDTO = ProposalDTO.builder()
                .employeeId(entity.getId())
                .firstDay(LocalDate.of(2022, 7, 1))
                .lastDay(LocalDate.of(2022, 8, 14))
                .tripType(TripType.PAID_BY_THE_COMPANY)
                .country("Thailand")
                .city("Bangkok")
                .isTripWithAccommodation(true)
                .build();
    }

    @Test
    void createProposal() {
        final ResponseEntity<String> proposal = proposalService.createProposal(proposalDTO);
        final String body = proposal.getBody();
    }
}