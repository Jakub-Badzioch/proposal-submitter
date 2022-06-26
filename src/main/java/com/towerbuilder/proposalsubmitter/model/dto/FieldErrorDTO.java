package com.towerbuilder.proposalsubmitter.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldErrorDTO {
    private String fieldName;
    private String message;
}
