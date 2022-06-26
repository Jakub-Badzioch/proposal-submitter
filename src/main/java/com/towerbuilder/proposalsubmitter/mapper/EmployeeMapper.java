package com.towerbuilder.proposalsubmitter.mapper;

import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDto(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}
