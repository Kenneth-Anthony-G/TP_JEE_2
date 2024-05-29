package GLSIAGROUPE13.TP_JEE.service;

import GLSIAGROUPE13.TP_JEE.dto.LoginDto;
import GLSIAGROUPE13.TP_JEE.model.authentification.AuthentificationResponseModel;
import GLSIAGROUPE13.TP_JEE.model.authentification.ClientProfileResponseModel;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public interface IAuthService {
    AuthentificationResponseModel login(LoginDto loginDto);
    ClientProfileResponseModel getUserProfile();
}
