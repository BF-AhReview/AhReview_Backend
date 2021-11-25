package com.bulgogifriedrice.backend.global.security;

import com.bulgogifriedrice.backend.global.security.detail.AuthUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getUserEmail() {
        Authentication auth = getAuthentication();
        return ((AuthUserDetails) auth.getPrincipal()).getUser().getEmail();
    }
}
