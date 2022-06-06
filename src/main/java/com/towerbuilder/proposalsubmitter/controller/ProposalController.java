package com.towerbuilder.proposalsubmitter.controller;

import com.towerbuilder.proposalsubmitter.dto.ProposalDTO;
import com.towerbuilder.proposalsubmitter.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<String> createProposal(@RequestBody ProposalDTO dto) {
        return proposalService.createProposal(dto);
    }
}
