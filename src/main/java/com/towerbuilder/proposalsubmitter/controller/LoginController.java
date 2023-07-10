package com.towerbuilder.proposalsubmitter.controller;

import com.towerbuilder.proposalsubmitter.model.dto.CredentialsDTO;
import com.towerbuilder.proposalsubmitter.model.dto.JwtTokenDTO;
import com.towerbuilder.proposalsubmitter.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public JwtTokenDTO login(@RequestBody CredentialsDTO credentialsDTO){
        return loginService.logIn(credentialsDTO.getEmail(), credentialsDTO.getPassword());
    }
}
