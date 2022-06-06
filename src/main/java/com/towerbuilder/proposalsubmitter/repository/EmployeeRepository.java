package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.entity.implementation.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
   // @Query("select e from EmployeeEntity e where e.email = ?1")
   // Optional<EmployeeEntity> findByEmail(String email);
}
