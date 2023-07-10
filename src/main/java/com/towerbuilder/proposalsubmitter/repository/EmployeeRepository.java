package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.model.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee> findByEmail(@NonNull String email);
}
