package GLSIAGROUPE13.TP_JEE.dto;

import GLSIAGROUPE13.TP_JEE.entity.Client;
import GLSIAGROUPE13.TP_JEE.entity.Compte;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private int clientId;
    private String nom;
    private LocalDate dnaissance;
    private String prenom;
    private String email;
    private String password;
    private String sexe;
    private String adresse;
    private String numero;
    private String nationalite;
    @JsonIgnore
    private List<Compte> compteList;


    public static Client convertToEntity(ClientDto clientDto) {
        return Client.builder()
                .clientId(clientDto.getClientId())
                .nom(clientDto.getNom())
                .prenom(clientDto.getPrenom())
                .email(clientDto.getEmail())
                .password(clientDto.getPassword())
                .dnaissance(clientDto.getDnaissance())
                .adresse(clientDto.getAdresse())
                .sexe(clientDto.getSexe())
                .numero(clientDto.getNumero())
                .nationalite(clientDto.getNationalite())
                .build();
    }

    public static  ClientDto convertToDto(Client client) {
        return ClientDto.builder()
                .clientId(client.getClientId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .password(client.getPassword())
                .adresse(client.getAdresse())
                .sexe(client.getSexe())
                .dnaissance(client.getDnaissance())
                .numero(client.getNumero())
                .nationalite(client.getNationalite())
                .build();
    }

}
