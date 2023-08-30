package com.easycontrat.ServiceImp;


import com.easycontrat.Dto.UtilisateurDto;
import com.easycontrat.Entity.Role;
import com.easycontrat.Entity.Utilisateur;
import com.easycontrat.Repository.RoleRepository;
import com.easycontrat.Repository.UtilisateurRepository;
import com.easycontrat.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
@Service
public class UtilisateurServiceImp implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Utilisateur register(UtilisateurDto utilisateurDto) {
        Utilisateur user = new Utilisateur();
        user.setNom(utilisateurDto.getNom());
        user.setPrenom(utilisateurDto.getPrenom());
        user.setDateNaissance(utilisateurDto.getDateNaissance());
        user.setTelephone(utilisateurDto.getTelephone());
        user.setEmail(utilisateurDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(utilisateurDto.getPassword()));

        Role role = roleRepository.findByLibelle("ROLE_ADMIN");
        if (role == null) {
            role = new Role();
            role.setLibelle("ROLE_ADMIN");
            role = roleRepository.save(role);
        }
        user.setRoles(Arrays.asList(role));
        return utilisateurRepository.save(user);

    }

    @Override
    public Utilisateur login(String email, String password) {
        Utilisateur user = utilisateurRepository.findByEmail(email);
        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Identifiants invalides");
        }

    }

    @Override
    public List<Utilisateur> getAllUsers() {

        return utilisateurRepository.findAll();
    }

}
