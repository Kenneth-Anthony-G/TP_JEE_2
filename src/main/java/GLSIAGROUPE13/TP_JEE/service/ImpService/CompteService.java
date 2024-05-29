package GLSIAGROUPE13.TP_JEE.service.ImpService;

import GLSIAGROUPE13.TP_JEE.dto.ClientDto;
import GLSIAGROUPE13.TP_JEE.dto.CompteDto;
import GLSIAGROUPE13.TP_JEE.dto.TransactionDto;
import GLSIAGROUPE13.TP_JEE.entity.Compte;
import GLSIAGROUPE13.TP_JEE.entity.Transaction;
import GLSIAGROUPE13.TP_JEE.repository.CompteRepository;
import GLSIAGROUPE13.TP_JEE.repository.TransactionRepository;
import GLSIAGROUPE13.TP_JEE.service.ICompteService;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class CompteService implements ICompteService {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private TransactionRepository transactionRepository;



    @Override
    public Compte saveCompte(Compte compte) {
        Iban iban = Iban.random();
        compte.setCompteNum(iban.toString());
        return compteRepository.save(compte);
    }

    @Override
    public List<CompteDto> showAllCompte() {
        return compteRepository.findAll().stream().map(CompteDto::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CompteDto getOneCompte(int id) {
        return CompteDto.convertToDto(compteRepository.getOne(id));
    }

    @Override
    public void deleteCompte(int id) {
        compteRepository.deleteById(id);
    }

    @Override
    public Compte getOneByNum_compte(String num_compte) {
        return compteRepository.findByCompteNum(num_compte);
    }


   /* @Override
    public int depot(float montant,Long id) {
        CompteDto compte = CompteDto.convertToDto(compteRepository.getOne(id));
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(CompteDto.convertToEntity(compte));
        Transaction transaction = Transaction.builder()
                .designation("depot")
                .montant(montant)
                .dtransaction(LocalDate.now())
                .compte(CompteDto.convertToEntity(compte))
                .build();
        transactionRepository.save(transaction);
        return 0;
    }

    @Override
    public int retrait(float montant, Long id) {
        CompteDto compte = CompteDto.convertToDto(compteRepository.getOne(id));
        compte.setSolde(compte.getSolde()-montant);
        compteRepository.save(CompteDto.convertToEntity(compte));
        Transaction transaction = Transaction.builder()
                .designation("retrait")
                .montant(montant)
                .dtransaction(LocalDate.now())
                .compte(CompteDto.convertToEntity(compte))
                .build();
        transactionRepository.save(transaction);
        return 0;
    }

    @Override
    public int virement(float montant, Long id_principale, Long id_secondaire) {
        retrait(montant,id_principale);
        depot(montant,id_secondaire);
        return 0;
    }*/
}
