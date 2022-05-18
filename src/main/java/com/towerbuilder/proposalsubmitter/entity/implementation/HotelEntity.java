package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class HotelEntity extends AbstractEntity {
    private String name;
    private String country;
    private String city;
    private String street;
}
