package com.easycontrat.Dto;

import com.easycontrat.Entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
@AllArgsConstructor@NoArgsConstructor@Data
public class UtilisateurDto {

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    @JsonFormat(pattern =  "yyyy-MM-dd")
    private Date dateNaissance;
    private List<Role> roles;
}
