package com.easycontrat.Service;

import com.easycontrat.Dto.UtilisateurDto;
import com.easycontrat.Entity.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    public Utilisateur register(UtilisateurDto utilisateurDto);
    public Utilisateur login(String email,String password);
    public List<Utilisateur> getAllUsers();
}
