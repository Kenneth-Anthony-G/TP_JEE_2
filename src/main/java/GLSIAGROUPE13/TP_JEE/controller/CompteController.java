package GLSIAGROUPE13.TP_JEE.controller;

import GLSIAGROUPE13.TP_JEE.dto.CompteDto;
import GLSIAGROUPE13.TP_JEE.entity.Compte;
import GLSIAGROUPE13.TP_JEE.service.ImpService.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ega/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;


    @PostMapping("/")
    public Compte saveCompte(@RequestBody Compte compte){
        return compteService.saveCompte(compte);
    }

    @GetMapping("/All")
    public List<CompteDto> showAllCompte(){
        return compteService.showAllCompte();
    }

    @GetMapping("/One")
    public CompteDto getOneCompte(int id){
        return compteService.getOneCompte(id);
    }

    @DeleteMapping("/Del")
    public void deleteCompte(int id){
        compteService.deleteCompte(id);
    }
    @PostMapping("/Dep/{id}/{montant}")
    public int depot(@PathVariable("id") int id,@PathVariable("montant") float montant){

        return 0;
    }
    @PostMapping("/Ret/{id}/{montant}")
    public int retrait(@PathVariable("id") int id,@PathVariable("montant") float montant){

        return 0;
    }
}
