package com.easycontrat.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom", nullable = true)
    private String nom;
    @Column(name = "prenom", nullable = true)
    private String prenom;
    @Column(name = "e_mail", nullable = false)
    private String email;

    @Column(name = "password", nullable = true)
    private String password;
    @Column(name = "telephone", nullable = true)
    private String telephone;

    @JsonFormat(pattern =  "yyyy-MM-dd")
    @Column(name = "date_naissance", nullable = true)
    private Date dateNaissance;

    @Column(name = "date_supp", nullable = true)
    private Date dateSupp;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="USERS_ROLES",  joinColumns= {@JoinColumn(name="USER_ID")},   inverseJoinColumns= {@JoinColumn(name="ROLE_ID")})
    private List<Role> roles;
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Entreprise> entreprises;
}
