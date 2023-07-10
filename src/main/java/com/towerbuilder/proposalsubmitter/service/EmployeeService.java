package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.exception.CurrentUserNotFoundException;
import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dto.EmployeeDTO;
import com.towerbuilder.proposalsubmitter.mapper.EmployeeMapper;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import com.towerbuilder.proposalsubmitter.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployeeDTO register(EmployeeDTO employeeDTO) {
        final Employee employee = employeeMapper.toEntity(employeeDTO);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    // throws tylko do exceptionow a do runtimeow juz nie
    public Employee findCurrentlyLoggedIn() {
        final String userName = SecurityUtils.getUserName();
        return employeeRepository.findByEmail(userName)
                .orElseThrow(() -> new CurrentUserNotFoundException(userName));
    }
}
