package GLSIAGROUPE13.TP_JEE.repository;

import GLSIAGROUPE13.TP_JEE.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Integer> {

    Compte findByCompteNum(String numCompte);

}
