package com.towerbuilder.proposalsubmitter.validator.impl;

import com.towerbuilder.proposalsubmitter.model.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.validator.LastDayIsAfterFirstDay;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LastDayIsAfterFirstDayImpl implements ConstraintValidator<LastDayIsAfterFirstDay, ProposalDTO> {
    @Override
    public boolean isValid(ProposalDTO value, ConstraintValidatorContext context) {
        return value.getFirstDay().isBefore(value.getLastDay());
    }
}
