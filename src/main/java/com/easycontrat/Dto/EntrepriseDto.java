package com.easycontrat.Dto;

import com.easycontrat.Entity.Adresse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.Set;

@Data
public class EntrepriseDto {

    private Long id;
    private String libelle;
    private String email;
    private String telephone;
    private String effictif;
    private String formeJuridique;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateSupp;
    private Long numero;
    private String typeVoie;
    private String nomVoie;
    private String codePostale;
    private String ville;
    private Set<Adresse> adresses;
}
