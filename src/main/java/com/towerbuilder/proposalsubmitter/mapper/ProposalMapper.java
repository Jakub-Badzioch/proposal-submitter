package com.towerbuilder.proposalsubmitter.mapper;

import com.towerbuilder.proposalsubmitter.model.dao.Proposal;
import com.towerbuilder.proposalsubmitter.model.dto.ProposalDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProposalMapper {
    Proposal toEntity(ProposalDTO proposalDTO);
    ProposalDTO toDTO(Proposal proposal);
    List<ProposalDTO> toProposalDTOList(List<Proposal> proposals);
}
