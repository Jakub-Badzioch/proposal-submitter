package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import com.towerbuilder.proposalsubmitter.entity.enumeration.TripReason;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
public class TripEntity extends AbstractEntity {
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(length=19)
    private TripReason tripReason;
}
