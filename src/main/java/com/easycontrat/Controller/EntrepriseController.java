package com.easycontrat.Controller;

import com.easycontrat.Dto.EntrepriseDto;
import com.easycontrat.Entity.Entreprise;
import com.easycontrat.Service.EntrepriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entreprise")
public class EntrepriseController {

    private Logger logger = LoggerFactory.getLogger(EntrepriseController.class);
    @Autowired
    private EntrepriseService entrepriseService;

    @PostMapping("/addEntreprise")
    public Entreprise addEntreprise(@RequestBody EntrepriseDto entrepriseDto){
        logger.info("add entreprise");
        return entrepriseService.addEntreprise(entrepriseDto);
    }
    @GetMapping("/getEntreprise")
    public List<Entreprise> getAllEntreprise(){
        logger.info("getAllEntreprises");
       return entrepriseService.getAllEntreprise();
    }
}
