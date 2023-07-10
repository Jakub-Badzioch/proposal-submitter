package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.model.Grade;
import com.towerbuilder.proposalsubmitter.model.Status;
import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dao.Proposal;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import com.towerbuilder.proposalsubmitter.repository.ProposalRepository;
import com.towerbuilder.proposalsubmitter.service.email.EmailService;
import com.towerbuilder.proposalsubmitter.utils.GradeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProposalService {

    // todo zrob cos z zapisem plikow zeby mozna bylo potestowac
    private final EmployeeRepository employeeRepository;
    private final ProposalRepository proposalRepository;
    private final EmailService emailService;


    public Proposal createProposal(Proposal proposal, Long employeeId) {
        final Employee employee = employeeRepository.getReferenceById(employeeId);
        String text;
        if (employee.getGrade()==Grade.F) {
            proposal.setStatus(Status.ACCEPTED);
            text = "Thank you for applying for work travel. We wish you a pleasant trip.";
        } else {
            proposal.setStatus(Status.WAITING_FOR_ACCEPTANCE);
            text = "Thank you for applying for work travel. You will be informed by e-mail whether an employee with " +
                    "higher grade has considered your application.";
        }
        emailService.sendMail(employee.getEmail(), "confirmation of sending proposal", text);
        proposal.setEmployee(employee);
        return proposalRepository.save(proposal);
    }

    // wartości do zmiany w encji powinny byc w body
    public Proposal updateProposalsStatus(Long proposalId, Long statusChangerId, Status newStatus) {
        final Employee statusChanger = employeeRepository.getReferenceById(statusChangerId);
        final Proposal proposal = proposalRepository.getReferenceById(proposalId);
        String subject;
        String text;
        if (newStatus == Status.ACCEPTED) {
            subject = "confirmation of accepting proposal";
            text = "Your application has been accepted by ";
        } else {
            subject = "confirmation of proposal's rejection";
            text = "Your application has been rejected by ";
        }
        text = text + statusChanger.getFirstName() + " " + statusChanger.getLastName();
        emailService.sendMail(proposal.getEmployee().getEmail(), subject, text);
        proposal.setStatus(newStatus);
        return proposalRepository.save(proposal);
    }

    // niech bachend przyjmuje tylko to co jest niezbedne nic wiecej
    public List<Proposal> readAllManageableProposals(Grade grade, Long companyBranchId) {
        return proposalRepository.findByEmployeeCompanyBranchIdAndStatusOrderByEmployeeFirstName(companyBranchId, Status.WAITING_FOR_ACCEPTANCE).stream()
                .filter(proposal -> GradeUtils.isGradesValid(grade, proposal.getEmployee().getGrade()))
                .collect(Collectors.toList());
    }
}