package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.entity.enumeration.Grade;
import com.towerbuilder.proposalsubmitter.entity.implementation.EmployeeEntity;
import com.towerbuilder.proposalsubmitter.entity.implementation.ProposalEntity;
import com.towerbuilder.proposalsubmitter.mapper.ProposalMapper;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import com.towerbuilder.proposalsubmitter.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProposalService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProposalRepository proposalRepository;
    @Autowired
    private EmailService emailService;

    public ResponseEntity<String> createProposal(ProposalDTO proposalDTO){
        final Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(proposalDTO.getEmployeeId());
        if (optionalEmployee.isEmpty()) return ResponseEntity.badRequest().body("There is no employee with such id");
        EmployeeEntity employee = optionalEmployee.get();
        ProposalEntity proposal = ProposalMapper.toEntity(proposalDTO);
        String to = "";
        String subject = "";
        String text = "";
        if (employee.getGrade().equals(Grade.F)){
            proposal.setIsAccepted(true);
            text = "Thank you for applying for work travel. We wish you a pleasant trip.";
        } else {
            proposal.setIsAccepted(false);
            text = "Thank you for applying for work travel. You will be informed by e-mail whether an employee with higher grade has considered your application.";
        }
        proposal.setEmployee(employee);
        proposalRepository.save(proposal);
        emailService.sendMail(employee.getEmail(), "confirmation of sending proposal", text);
        return ResponseEntity.ok().build();
    }
}
