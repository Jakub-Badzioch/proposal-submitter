package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.entity.implementation.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
}
