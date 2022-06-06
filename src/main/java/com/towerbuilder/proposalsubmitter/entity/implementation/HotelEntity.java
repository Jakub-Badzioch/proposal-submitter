package com.towerbuilder.proposalsubmitter.entity.implementation;

import com.towerbuilder.proposalsubmitter.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity(name = "hotel")
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity extends AbstractEntity {

    @OneToMany(mappedBy = "hotel")
    private List<ProposalEntity> proposals;

    private String name;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
}
