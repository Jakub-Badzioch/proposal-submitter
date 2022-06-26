package com.towerbuilder.proposalsubmitter.repository;

import com.towerbuilder.proposalsubmitter.model.dao.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
