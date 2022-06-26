package com.towerbuilder.proposalsubmitter.controller;

import com.towerbuilder.proposalsubmitter.model.dto.EmployeeDTO;
import com.towerbuilder.proposalsubmitter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO register(@RequestBody @Valid EmployeeDTO employeeDto) {
        return employeeService.register(employeeDto);
    }
}
