package com.towerbuilder.proposalsubmitter.service

import com.towerbuilder.proposalsubmitter.exception.CurrentUserNotFoundException
import com.towerbuilder.proposalsubmitter.mapper.EmployeeMapper
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class EmployeeServiceSpec extends Specification {

    def employeeRepository = Mock(EmployeeRepository)
    def employeeMapper = Mock(EmployeeMapper)
    def passwordEncoder = Mock(PasswordEncoder)
    def employeeService = new EmployeeService(employeeRepository, employeeMapper, passwordEncoder)

    def 'should throw CurrentUserNotFoundException'() {
        given:
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)
        def authentication = Mock(Authentication)

        when:
        employeeService.findCurrentlyLoggedIn()

        then:
        1 * securityContext.getAuthentication() >> authentication
        1 * authentication.getName() >> 'abc@test.com'
        1 * employeeRepository.findByEmail('abc@test.com') >> Optional.empty()
        0 * _

        // alt + enter = generowanie zmiennej
        def e = thrown CurrentUserNotFoundException
        e.message == 'abc@test.com'
        // koniec s3ekcji then
    }
}
