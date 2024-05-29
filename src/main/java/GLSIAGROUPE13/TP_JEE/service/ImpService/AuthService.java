package GLSIAGROUPE13.TP_JEE.service.ImpService;


import GLSIAGROUPE13.TP_JEE.dto.LoginDto;
import GLSIAGROUPE13.TP_JEE.entity.Client;
import GLSIAGROUPE13.TP_JEE.model.authentification.AuthentificationResponseModel;
import GLSIAGROUPE13.TP_JEE.model.authentification.ClientProfileResponseModel;
import GLSIAGROUPE13.TP_JEE.repository.ClientRepository;
import GLSIAGROUPE13.TP_JEE.security.JwtService;
import GLSIAGROUPE13.TP_JEE.service.IAuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final ClientRepository clientRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthentificationResponseModel login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        var user = clientRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User " + loginDto.getEmail() + " Not Found"));

        return AuthentificationResponseModel.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public ClientProfileResponseModel getUserProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Client user = clientRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        return ClientProfileResponseModel
                .builder()
                .email(user.getEmail())
                .name(user.getNom()+" "+user.getPrenom())
                .phone(user.getNumero())
                .build();
    }
}
