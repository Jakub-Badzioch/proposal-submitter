package com.towerbuilder.proposalsubmitter.service;

import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dto.EmployeeDTO;
import com.towerbuilder.proposalsubmitter.mapper.EmployeeMapper;
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDTO register(EmployeeDTO employeeDTO) {
        final Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }
}
