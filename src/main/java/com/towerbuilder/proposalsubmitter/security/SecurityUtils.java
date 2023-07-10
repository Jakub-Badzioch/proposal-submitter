package com.towerbuilder.proposalsubmitter.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUtils {

    public static String getUserName() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // elvis expression to skrócony if else
        return authentication != null ? authentication.getName() : null;
    }
}
