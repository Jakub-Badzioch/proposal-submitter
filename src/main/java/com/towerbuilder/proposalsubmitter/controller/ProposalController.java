package com.towerbuilder.proposalsubmitter.controller;

import com.towerbuilder.proposalsubmitter.mapper.EmployeeMapper;
import com.towerbuilder.proposalsubmitter.mapper.ProposalMapper;
import com.towerbuilder.proposalsubmitter.model.Grade;
import com.towerbuilder.proposalsubmitter.model.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.model.dto.ProposalsStatusChangeDTO;
import com.towerbuilder.proposalsubmitter.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5/proposals")
@PreAuthorize("isAuthenticated()")
public class ProposalController {
    private final ProposalService proposalService;
    private final ProposalMapper proposalMapper;
    private final EmployeeMapper employeeMapper;

    // test containers - biblioteka ktora umozliwia odpalenie na dockerze testow integracyjnych na bazie sqlowej a nie h2
    // jest to zalecane bo testuje 100% a h2 nie
    @PostMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProposalDTO createProposal(@Valid @RequestBody ProposalDTO dto, @PathVariable("employeeId") Long employeeId) {
        return proposalMapper.toDTO(proposalService.createProposal(proposalMapper.toEntity(dto), employeeId));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProposalDTO changeProposalsStatus(@RequestBody ProposalsStatusChangeDTO dto) {
        return proposalMapper.toDTO(proposalService.updateProposalsStatus(dto.getProposalId(), dto.getStatusChangerId(),
                dto.getNewStatus()));
    }

    // w getMapppingu jesli chce filtrowac pageowac itp to musze zawsze podac request paramsy
    // nie ma sensu tworzyc nowej klasy DTO na to zeby przekazac dwie zmienne
    @GetMapping
    public List<ProposalDTO> readAllManageableProposals(@RequestParam Grade grade, @RequestParam Long companyBranchId) {
        return proposalMapper.toProposalDTOList(proposalService.readAllManageableProposals(grade, companyBranchId));
    }
}
