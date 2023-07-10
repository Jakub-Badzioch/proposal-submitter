package com.towerbuilder.proposalsubmitter.mapper;

import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import com.towerbuilder.proposalsubmitter.model.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeDTO employeeDTO);
    @Mapping(target = "password", ignore = true)
    EmployeeDTO toDto(Employee employee);
}
