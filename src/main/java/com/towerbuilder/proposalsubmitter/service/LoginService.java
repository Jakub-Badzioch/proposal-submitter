package com.towerbuilder.proposalsubmitter.service;


import com.towerbuilder.proposalsubmitter.model.dto.JwtTokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    public JwtTokenDTO logIn(String email, String password) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        // rzuca badcredentialsexcp
        // w takich klasach obiekty zmienne na ich podstawie nazywaj najbardziej podobnnie do nazwy klasy.
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(email)
                .expiresAt(Instant.now().plus(Duration.ofDays(1)))
                .claim("scope", "USER")
                .build();
        final String tokenValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new JwtTokenDTO(tokenValue);
    }
}
