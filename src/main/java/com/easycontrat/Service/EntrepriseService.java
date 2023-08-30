package com.easycontrat.Service;

import com.easycontrat.Dto.EntrepriseDto;
import com.easycontrat.Entity.Entreprise;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntrepriseService {

    public Entreprise addEntreprise(EntrepriseDto entrepriseDto);
    public List<Entreprise> getAllEntreprise();
}
