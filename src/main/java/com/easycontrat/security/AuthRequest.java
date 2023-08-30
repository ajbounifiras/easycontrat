package com.easycontrat.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class AuthRequest {
    private String email;
    private String password;

}
