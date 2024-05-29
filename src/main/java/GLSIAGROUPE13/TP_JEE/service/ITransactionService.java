package GLSIAGROUPE13.TP_JEE.service;

import GLSIAGROUPE13.TP_JEE.dto.TransactionDto;
import GLSIAGROUPE13.TP_JEE.entity.Transaction;

import java.util.List;

public interface ITransactionService {

    public Transaction saveTransaction(Transaction transaction);
    public TransactionDto getOneTransaction(int id);
    public List<TransactionDto> showAllTransaction();
    public void deleteTransaction(int id);
    public int depot(Transaction transaction);
    public int retrait(Transaction transaction);
    public int virement(Transaction transaction);
    public List<TransactionDto> getAllByCompteId(int compteId);



}
