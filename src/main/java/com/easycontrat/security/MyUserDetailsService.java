package com.easycontrat.security;

import com.easycontrat.Entity.Role;
import com.easycontrat.Entity.Utilisateur;
import com.easycontrat.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = utilisateurRepository.findByEmail(username);
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = new User(
              username,
              user.getPassword(),
              true,
              accountNonExpired,
              credentialsNonExpired,
              accountNonLocked,
              getAuthorities((user.getRoles())));
        return userDetails;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role role: roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getLibelle());
            grantedAuthorities.add(grantedAuthority);
        }
        return grantedAuthorities;
    }
}
