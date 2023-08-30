package com.easycontrat.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contact")
@Data@AllArgsConstructor@NoArgsConstructor
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String typeContrat;
    @JsonFormat(pattern =  "yyyy-MM-dd")
    @Column(name = "date_debut", nullable = true)
    private Date dateDebut;
    @JsonFormat(pattern =  "yyyy-MM-dd")
    @Column(name = "date_fin", nullable = true)
    private Date dateFin;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Salarier salarier;
}
