package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmailEquals(@NonNull String email);
}
