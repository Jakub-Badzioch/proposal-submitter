package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.model.dto.ProposalAcceptanceDTO;
import com.towerbuilder.proposalsubmitter.model.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.model.Grade;
import com.towerbuilder.proposalsubmitter.model.TripReason;
import com.towerbuilder.proposalsubmitter.model.TripType;
import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dao.Proposal;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import com.towerbuilder.proposalsubmitter.repository.ProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setFirstName("Jan");
        employee.setLastName("Polski");
        employee.setBirthDate(LocalDate.of(1978, 9, 9));
        employee.setEmail("bodziov3@gmail.com");
        employee.setTelephoneNumber("512587425");
        employee.setCountry("Poland");
        proposalDTO = ProposalDTO.builder()
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
    void shouldCreateAcceptedProposal() {
        // given
        employee.setGrade(Grade.F);
        employeeRepository.save(employee);
        proposalDTO.setEmployeeId(employee.getId());
        // when
      //  final ResponseEntity<String> response = proposalService.createProposal(proposalDTO);
        final List<Proposal> all = proposalRepository.findAll();
        // then
     //   assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(all).hasSize(1);
        assertThat(all.get(0).getEmployee().getId()).isEqualTo(employee.getId());
        assertThat(all.get(0).getIsAccepted()).isTrue();
    }

    @Test
    void shouldCreateNotAcceptedProposal() {
        // given
        employee.setGrade(Grade.C);
        employeeRepository.save(employee);
        proposalDTO.setEmployeeId(employee.getId());
        // when
     //   final ResponseEntity<String> response = proposalService.createProposal(proposalDTO);
        final List<Proposal> all = proposalRepository.findAll();
        // then
     //   assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(all).hasSize(1);
        assertThat(all.get(0).getEmployee().getId()).isEqualTo(employee.getId());
        assertThat(all.get(0).getIsAccepted()).isFalse();
    }

    @Test
    void shouldNotFindEmployeeAndNotCreateProposal() {
        // given
        proposalDTO.setEmployeeId(-1L);
        // when
     //   final ResponseEntity<String> response = proposalService.createProposal(proposalDTO);
        final List<Proposal> all = proposalRepository.findAll();
        // then
    //    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(all).isEmpty();
    //    assertThat(response.getBody()).isEqualTo("There is no employee with such id");
    }

    @Test
    void shouldNotFindEmployeeAndNotAcceptProposal() {
        // given
        final Employee supervisor = new Employee();
        supervisor.setFirstName("Grzegorz");
        supervisor.setLastName("Pruski");
        supervisor.setBirthDate(LocalDate.of(1978, 9, 9));
        supervisor.setEmail("borsuk78@gmail.com");
        supervisor.setTelephoneNumber("555555555");
        supervisor.setCountry("Poland");
        supervisor.setGrade(Grade.F);
        employee.setGrade(Grade.C);
        employeeRepository.save(supervisor);
        employeeRepository.save(employee);
        proposalDTO.setEmployeeId(employee.getId());
      //  proposalService.createProposal(proposalDTO, dto.getEmployeeId());
        final Proposal proposal = proposalRepository.findAll().get(0);
        final ProposalAcceptanceDTO dto = ProposalAcceptanceDTO.builder()
                .acceptingEmployeeId(supervisor.getId())
                .proposalId(proposal.getId())
                .build();
        // when
   //     final ResponseEntity<String> response = proposalService.acceptProposal(dto);
        final List<Employee> employees = employeeRepository.findAll();
        final List<Proposal> proposals = proposalRepository.findAll();
        // then
   //     assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(employees).hasSize(2);
        assertThat(proposals.get(0).getEmployee().getId()).isEqualTo(employee.getId());
        assertThat(proposals.get(0).getIsAccepted()).isTrue();
    }

    @Test
    void shouldNotFindProposalAndNotAcceptProposal() {

    }

    @Test
    void shouldNotAcceptProposalBecauseOfWrongGrade() {
    }

    @Test
    void shouldAcceptProposal() {
    }
}
