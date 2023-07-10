package com.towerbuilder.proposalsubmitter.service

import com.fasterxml.jackson.databind.annotation.JsonAppend
import com.towerbuilder.proposalsubmitter.model.Grade
import com.towerbuilder.proposalsubmitter.model.Status
import com.towerbuilder.proposalsubmitter.model.dao.Employee
import com.towerbuilder.proposalsubmitter.model.dao.Proposal
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository
import com.towerbuilder.proposalsubmitter.repository.ProposalRepository
import com.towerbuilder.proposalsubmitter.service.email.EmailService
import spock.lang.Specification

class ProposalServiceSpec extends Specification {
    // def to skrot od definition.
    // nie ma modyfikatorow dostepu

    // groovy powstal do pisania skryptow ale jest tez dobry do testow
    // skrypty to takie krotkie kawalki kodu do wykonywania. nie aplikacja ale jakas tam funkcja cos tam, robi
    // dzieki skryptom devopsi ulatwiaja wszystkim zycie. umozliwają wszystkie procesy wdrozeniowe aplikacji
    def employeeRepository = Mock(EmployeeRepository)
    def proposalRepository = Mock(ProposalRepository)
    def emailService = Mock(EmailService)
    def proposalService = new ProposalService(employeeRepository, proposalRepository, emailService)

    def 'should save proposal'() {
        given:
        def proposal = Mock(Proposal)
        def employeeId = 1
        def employee = Mock(Employee)

        when:
        proposalService.createProposal(proposal, employeeId)

        then:
        1 * employeeRepository.getReferenceById(employeeId) >> employee
        1 * employee.getGrade() >> grade
        1 * proposal.setStatus(status)
        1 * employee.getEmail() >> "abc@gmail.com"
        1 * emailService.sendMail("abc@gmail.com", "confirmation of sending proposal", text)
        1 * proposal.setEmployee(employee)
        1 * proposalRepository.save(proposal)
        System.out.println(employee)
        0 * _
        // 0*_ oznacza ze juz nic wiecej sie nie wykona

        where:
        grade   | status                        | text
        Grade.F | Status.ACCEPTED               | "Thank you for applying for work travel. We wish you a pleasant trip."
        Grade.A | Status.WAITING_FOR_ACCEPTANCE | "Thank you for applying for work travel. You will be informed by e-mail whether an employee with " +
                "higher grade has considered your application."
    }

    def 'should update status of proposal'() {
        given:
        def proposalId = 1
        def statusChangerId = 1
        def statusChanger = Mock(Employee)
        def proposal = Mock(Proposal)
        def employee = Mock(Employee)

        when:
        proposalService.updateProposalsStatus(proposalId, statusChangerId, newStatus)

        then:
        1 * employeeRepository.getReferenceById(statusChangerId) >> statusChanger
        1 * proposalRepository.getReferenceById(proposalId) >> proposal
        1 * statusChanger.getFirstName() >> "Jan"
        1 * statusChanger.getLastName() >> "Kowalski"
        1 * proposal.getEmployee() >> employee
        1 * employee.getEmail() >> "abc@gmail.com"
        1 * emailService.sendMail("abc@gmail.com", subject, text)
        1 * proposal.setStatus(newStatus)
        1 * proposalRepository.save(proposal)
        0 * _

        where:
        newStatus       | subject                                | text
        Status.ACCEPTED | "confirmation of accepting proposal"   | "Your application has been accepted by Jan Kowalski"
        Status.REJECTED | "confirmation of proposal's rejection" | "Your application has been rejected by Jan Kowalski"
    }

    // nie powinienem sprawdzac czy metody statyczne zostaly wykonane
    def 'should return list of proposals'() {
        given:
        def grade = Grade.E
        def companyBranchId = 1
        def proposals = [
                new Proposal(employee: new Employee(grade: Grade.A)),
                new Proposal(employee: new Employee(grade: Grade.D)),
                new Proposal(employee: new Employee(grade: Grade.F)),
                new Proposal(employee: new Employee(grade: Grade.C)),
        ]

        when:
        def result = proposalService.readAllManageableProposals(grade, companyBranchId)

        then:
        1 * proposalRepository.findByEmployeeCompanyBranchIdAndStatusOrderByEmployeeFirstName(companyBranchId, Status.WAITING_FOR_ACCEPTANCE) >> proposals
        0 * _

        result.size() == 3
    }
}
