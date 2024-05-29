package GLSIAGROUPE13.TP_JEE.dto;

import GLSIAGROUPE13.TP_JEE.entity.Compte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompteDto {
    private int compteId;
    private String compteNum;
    private LocalDate dcreation;
    private double solde;
    private ClientDto client;


    public static Compte convertToEntity(CompteDto compteDto) {
        return Compte.builder()
                .compteId(compteDto.getCompteId())
                .compteNum(compteDto.getCompteNum())
                .dcreation(compteDto.getDcreation())
                .solde(compteDto.getSolde())
                .client(ClientDto.convertToEntity(compteDto.getClient()))
                .build();
    }

    public static CompteDto convertToDto(Compte compte) {
        return CompteDto.builder()
                .compteId(compte.getCompteId())
                .compteNum(compte.getCompteNum())
                .solde(compte.getSolde())
                .dcreation(compte.getDcreation())
                .client(ClientDto.convertToDto(compte.getClient()))
                .build();
    }
}
