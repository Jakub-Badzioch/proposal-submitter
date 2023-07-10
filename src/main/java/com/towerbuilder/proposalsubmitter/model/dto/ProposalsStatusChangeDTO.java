package com.towerbuilder.proposalsubmitter.model.dto;

import com.towerbuilder.proposalsubmitter.model.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProposalsStatusChangeDTO {
    // idki moga byc w dto a mogą byc w linku jesli chce
    private Long proposalId;
    private Long statusChangerId;
    private Status newStatus;
}
