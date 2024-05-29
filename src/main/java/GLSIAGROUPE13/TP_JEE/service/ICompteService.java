package GLSIAGROUPE13.TP_JEE.service;

import GLSIAGROUPE13.TP_JEE.dto.ClientDto;
import GLSIAGROUPE13.TP_JEE.dto.CompteDto;
import GLSIAGROUPE13.TP_JEE.dto.TransactionDto;
import GLSIAGROUPE13.TP_JEE.entity.Client;
import GLSIAGROUPE13.TP_JEE.entity.Compte;
import jakarta.persistence.Lob;

import java.util.List;

public interface ICompteService {

    public Compte saveCompte(Compte compte);
    public List<CompteDto> showAllCompte();
    public CompteDto getOneCompte(int id);
    public void deleteCompte(int id);

    public Compte getOneByNum_compte(String num_compte);
    //public List<TransactionDto> getAlltransactionFromCompte(String compteNum);

}
