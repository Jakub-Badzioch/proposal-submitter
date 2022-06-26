package com.towerbuilder.proposalsubmitter.model.dao;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
@SuperBuilder
@ToString(callSuper=true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends Basic {

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Proposal> proposals;

    private String name;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (! super.equals(obj)) return false;
        Hotel hotel = (Hotel) obj;
        return Objects.equals(getProposals(), hotel.getProposals())
                && Objects.equals(getName(), hotel.getName())
                && Objects.equals(getCountry(), hotel.getCountry())
                && Objects.equals(getCity(), hotel.getCity())
                && Objects.equals(getStreet(), hotel.getStreet())
                && Objects.equals(getBuildingNumber(), hotel.getBuildingNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProposals(), getName(),
                getCountry(), getCity(), getStreet(), getBuildingNumber());
    }
}
