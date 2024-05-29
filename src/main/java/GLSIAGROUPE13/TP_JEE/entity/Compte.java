package GLSIAGROUPE13.TP_JEE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iban4j.Iban;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compteId;
    private String compteNum;
    private LocalDate dcreation;
    private double solde;

    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactionList;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
}
