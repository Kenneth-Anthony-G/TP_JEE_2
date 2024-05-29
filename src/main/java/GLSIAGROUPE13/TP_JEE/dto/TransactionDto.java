package GLSIAGROUPE13.TP_JEE.dto;

import GLSIAGROUPE13.TP_JEE.entity.Compte;
import GLSIAGROUPE13.TP_JEE.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TransactionDto {

    private int transactionId;
    private String designation;
    private double montant;
    private LocalDate dtransaction;
    private String fromCompte;
    private String toCompte;


    public static Transaction convertToEntity(TransactionDto transactionDto){
        return Transaction.builder()
                .transactionId(transactionDto.getTransactionId())
                .designation(transactionDto.getDesignation())
                .montant(transactionDto.getMontant())
                .dtransaction(transactionDto.getDtransaction())
                .fromCompte(transactionDto.getFromCompte())
                .toCompte(transactionDto.getToCompte())
                .build();
    }

    public static TransactionDto convertToDto(Transaction transaction){
        return TransactionDto.builder()
                .transactionId(transaction.getTransactionId())
                .designation(transaction.getDesignation())
                .montant(transaction.getMontant())
                .dtransaction(transaction.getDtransaction())
                .fromCompte(transaction.getFromCompte())
                .toCompte(transaction.getToCompte())
                .build() ;
    }

}
