package com.towerbuilder.proposalsubmitter.controller;

import com.towerbuilder.proposalsubmitter.mapper.ProposalMapper;
import com.towerbuilder.proposalsubmitter.model.dto.ProposalAcceptanceDTO;
import com.towerbuilder.proposalsubmitter.model.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/proposals")
public class ProposalController {
    private final ProposalService proposalService;
    private final ProposalMapper proposalMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProposalDTO createProposal(@RequestBody ProposalDTO dto) {
        return  proposalMapper.toDTO(proposalService.createProposal(proposalMapper.toEntity(dto), dto.getEmployeeId()));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProposalDTO acceptProposal(@RequestBody ProposalAcceptanceDTO dto) {
        return proposalMapper.toDTO(proposalService.acceptProposal(dto.getProposalId(), dto.getAcceptingEmployeeId()));
    }
}
