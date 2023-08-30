package com.easycontrat.Repository;

import com.easycontrat.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByNom(String userName);
    Utilisateur findByEmail(String email);

    boolean existsByEmail(String email);

    Utilisateur findUserByEmailAndPassword(String email, String password);
}
