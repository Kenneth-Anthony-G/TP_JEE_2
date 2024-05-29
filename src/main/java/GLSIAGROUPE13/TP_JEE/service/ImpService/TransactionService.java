package GLSIAGROUPE13.TP_JEE.service.ImpService;

import GLSIAGROUPE13.TP_JEE.dto.CompteDto;
import GLSIAGROUPE13.TP_JEE.dto.TransactionDto;
import GLSIAGROUPE13.TP_JEE.entity.Compte;
import GLSIAGROUPE13.TP_JEE.entity.Transaction;
import GLSIAGROUPE13.TP_JEE.repository.CompteRepository;
import GLSIAGROUPE13.TP_JEE.repository.TransactionRepository;
import GLSIAGROUPE13.TP_JEE.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public TransactionDto getOneTransaction(int id) {
        return TransactionDto.convertToDto(transactionRepository.getOne(id));
    }

    @Override
    public List<TransactionDto> showAllTransaction() {
        return transactionRepository.findAll().stream().map(TransactionDto::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(int id) {
        transactionRepository.deleteById(id);

    }

    @Override
    public int depot(Transaction transaction) {
        transactionRepository.save(transaction);
        Compte compte = compteRepository.findByCompteNum(transaction.getToCompte());
        compte.setSolde(compte.getSolde()+transaction.getMontant());
        compteRepository.save(compte);
        return 0;
    }

    @Override
    public int retrait(Transaction transaction) {
        transactionRepository.save(transaction);
        Compte compte = compteRepository.findByCompteNum(transaction.getFromCompte());
        compte.setSolde(compte.getSolde()-transaction.getMontant());
        compteRepository.save(compte);
        return 0;
    }

    @Override
    public int virement(Transaction transaction) {
        retrait(transaction);
        depot(transaction);
        return 0;
    }

    @Override
    public List<TransactionDto> getAllByCompteId(int compteId) {
        System.out.println("test1---------");
        return transactionRepository.findAllByCompteCompteId(compteId).stream().map(TransactionDto::convertToDto).collect(Collectors.toList());

    }


}
