package com.easycontrat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "salarier")
@Data@AllArgsConstructor@NoArgsConstructor
public class Salarier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenon;
    private String post;
    private String email;
    private EtatCivil etatCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy ="salarier",fetch = FetchType.EAGER)
    private Set<Contrat> contrats;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Entreprise entreprise;
}
