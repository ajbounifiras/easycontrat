package com.easycontrat.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "entreprise")
@Data@AllArgsConstructor@NoArgsConstructor
public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String libelle;
    private String email;
    private String telephone;
    private String effictif;
    private String formeJuridique;
    @Column(name = "date_supp", nullable = true)
    private Date dateSupp;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "entreprises",fetch = FetchType.EAGER)
    private Set<Utilisateur> utilisateurs;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "entreprise",fetch = FetchType.EAGER)
    @JsonManagedReference("entreprise")
    private Set<Adresse> adresses;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="entreprise",fetch = FetchType.EAGER)
    private Set<Salarier> salariers;
    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, email, telephone, effictif, formeJuridique, dateSupp);
    }
}
