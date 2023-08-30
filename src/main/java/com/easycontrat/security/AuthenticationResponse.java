package com.easycontrat.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@AllArgsConstructor @Data
public class AuthenticationResponse {
    private final String token;

    private final String username;

    private final Collection<? extends GrantedAuthority> authorities;


    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}
