package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.model.dao.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
