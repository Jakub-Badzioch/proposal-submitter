package com.towerbuilder.proposalsubmitter.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProposalAcceptanceDTO {
    private Long proposalId;
    private Long acceptingEmployeeId;
}
