package com.easycontrat.Repository;

import com.easycontrat.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
