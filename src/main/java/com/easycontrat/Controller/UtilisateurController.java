package com.easycontrat.Controller;

import com.easycontrat.Dto.UtilisateurDto;
import com.easycontrat.Entity.Utilisateur;
import com.easycontrat.Service.UtilisateurService;
import com.easycontrat.security.AuthenticationResponse;
import com.easycontrat.security.JwtUtil;
import com.easycontrat.security.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("user")
public class UtilisateurController {

    public static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/signup")
    public Utilisateur registerUser(@RequestBody UtilisateurDto utilisateurDto){
        logger.info("user signup");
        return utilisateurService.register(utilisateurDto);
    }
    @PostMapping("/auth/signin")
    public ResponseEntity<AuthenticationResponse> login(@RequestParam String email, @RequestParam String password) {
        try {
            Utilisateur user = utilisateurService.login(email, password);
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(email);
            String token = jwtUtil.generateToken(userDetails);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

            AuthenticationResponse response = new AuthenticationResponse(token, email, authorities);

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/getAllUsers")
    public List<Utilisateur> getAllUsers(){
        logger.info("get all users");
        return utilisateurService.getAllUsers();

    }
}
