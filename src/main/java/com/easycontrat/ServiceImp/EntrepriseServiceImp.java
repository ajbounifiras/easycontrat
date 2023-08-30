package com.easycontrat.ServiceImp;

import com.easycontrat.Dto.EntrepriseDto;
import com.easycontrat.Entity.Adresse;
import com.easycontrat.Entity.Entreprise;
import com.easycontrat.Repository.EntrepriseRepository;
import com.easycontrat.Service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class EntrepriseServiceImp implements EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Override
    public Entreprise addEntreprise(EntrepriseDto entrepriseDto) {
       Entreprise entreprise = new Entreprise();
       Adresse adresse = new Adresse();
       entreprise.setLibelle(entrepriseDto.getLibelle());
       entreprise.setEmail(entrepriseDto.getEmail());
       entreprise.setTelephone(entrepriseDto.getTelephone());
       entreprise.setFormeJuridique(entrepriseDto.getFormeJuridique());
       entreprise.setEffictif(entrepriseDto.getEffictif());
       entreprise.setDateSupp(entrepriseDto.getDateSupp());
        adresse.setNumero(entrepriseDto.getNumero());
        adresse.setTypeVoie(entrepriseDto.getTypeVoie());
        adresse.setNomVoie(entrepriseDto.getNomVoie());
        adresse.setCodePostale(entrepriseDto.getCodePostale());
        adresse.setVille(entrepriseDto.getVille());
        adresse.setEntreprise(entreprise);
        Set<Adresse> addresses = new HashSet<>();
        addresses.add(adresse);
        entreprise.setAdresses(addresses);
        return entrepriseRepository.save(entreprise);
    }
    @Transactional
    @Override
    public List<Entreprise> getAllEntreprise() {
       return entrepriseRepository.findAll();
    }

}
