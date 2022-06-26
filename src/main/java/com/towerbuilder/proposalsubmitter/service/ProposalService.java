package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.exception.TooLowGradeException;
import com.towerbuilder.proposalsubmitter.model.Grade;
import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dao.Proposal;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import com.towerbuilder.proposalsubmitter.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.towerbuilder.proposalsubmitter.utils.GradeUtils.isGradesValid;

@Service
@RequiredArgsConstructor
public class ProposalService {

    private final EmployeeRepository employeeRepository;
    private final ProposalRepository proposalRepository;
    private final EmailService emailService;

    public Proposal createProposal(Proposal proposal, Long employeeId) {
        final Employee employee = employeeRepository.getReferenceById(employeeId);
        String text;
        if (employee.getGrade().equals(Grade.F)) {
            proposal.setIsAccepted(true);
            text = "Thank you for applying for work travel. We wish you a pleasant trip.";
        } else {
            proposal.setIsAccepted(false);
            text = "Thank you for applying for work travel. You will be informed by e-mail whether an employee with higher grade has considered your application.";
        }
        proposal.setEmployee(employee);
        proposalRepository.save(proposal);
        emailService.sendMail(employee.getEmail(), "confirmation of sending proposal", text);
        return proposal;
    }

    public Proposal acceptProposal(Long proposalId, Long acceptingEmployeeId) {
        final Employee acceptor = employeeRepository.getReferenceById(acceptingEmployeeId);
        final Proposal proposal = proposalRepository.getReferenceById(proposalId);
        final Employee submitter = proposal.getEmployee();
        if (isGradesValid(acceptor.getGrade(), submitter.getGrade())) {
            proposal.setIsAccepted(true);
            proposalRepository.save(proposal);
            emailService.sendMail(submitter.getEmail(), "confirmation of accepting proposal",
                    "Your application has been accepted by " + acceptor.getFirstName()
                            + " " + acceptor.getLastName() + ". We wish you a pleasant trip");
            return proposal;
        }
        throw new TooLowGradeException("\"An employee with your grade cannot accept this proposal");
    }
}
