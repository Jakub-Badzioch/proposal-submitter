package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.model.Status;
import com.towerbuilder.proposalsubmitter.model.dao.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByEmployeeCompanyBranchIdAndStatusOrderByEmployeeFirstName(@NonNull Long companyBranchId, @NonNull Status status);
}
