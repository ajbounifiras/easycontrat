package com.easycontrat.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "adresse")
@Data@AllArgsConstructor@NoArgsConstructor
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long numero;
    private String typeVoie;
    private String nomVoie;
    private String codePostale;
    private String ville;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_supp", nullable = true)
    private Date dateSupp;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference("adresses")
    private Entreprise entreprise;

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, typeVoie, nomVoie, codePostale, ville, dateSupp);
    }

}