package GLSIAGROUPE13.TP_JEE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String designation;
    private double montant;
    private LocalDate dtransaction;
    private String fromCompte;
    private String toCompte;

    @ManyToOne
    @JoinColumn(name = "compteId")
    private Compte compte;

}
