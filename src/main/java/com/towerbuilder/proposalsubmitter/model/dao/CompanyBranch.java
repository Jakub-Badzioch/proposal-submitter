package com.towerbuilder.proposalsubmitter.model.dao;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranch extends Basic {
    @OneToMany(mappedBy = "companyBranch")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Employee> employees;
    private String name;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
}