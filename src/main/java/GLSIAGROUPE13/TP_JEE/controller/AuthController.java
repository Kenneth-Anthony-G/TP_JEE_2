package GLSIAGROUPE13.TP_JEE.controller;
import GLSIAGROUPE13.TP_JEE.dto.LoginDto;
import GLSIAGROUPE13.TP_JEE.model.ResponseModel;
import GLSIAGROUPE13.TP_JEE.service.ImpService.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ega")

public class AuthController {
    @Autowired
    private AuthService authenticationService;

    @PostMapping("/auth/login/")
    public ResponseEntity<ResponseModel> login(@RequestBody LoginDto request) {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .success(true)
                        .data(authenticationService.login(request))
                        .build()
                );
    }

    @GetMapping("/auth/profile")
    public ResponseEntity<ResponseModel> getUserProfile() {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(authenticationService.getUserProfile())
                        .build()
        );
    }
}