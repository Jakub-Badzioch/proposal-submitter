package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.entity.implementation.ProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<ProposalEntity, Long> {
}
