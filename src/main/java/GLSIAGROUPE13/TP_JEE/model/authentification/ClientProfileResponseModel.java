package GLSIAGROUPE13.TP_JEE.model.authentification;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientProfileResponseModel {
    private String email;
    private String name;
    private String phone;
}
