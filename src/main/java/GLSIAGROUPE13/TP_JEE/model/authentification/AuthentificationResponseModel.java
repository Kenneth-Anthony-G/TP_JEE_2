package GLSIAGROUPE13.TP_JEE.model.authentification;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthentificationResponseModel {
    private String token;
}
