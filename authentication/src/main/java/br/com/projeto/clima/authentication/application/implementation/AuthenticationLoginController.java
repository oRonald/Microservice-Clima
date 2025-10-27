package br.com.projeto.clima.authentication.application.implementation;

import br.com.projeto.clima.authentication.application.IAuthenticationLoginController;
import br.com.projeto.clima.authentication.dto.TokenResponse;
import br.com.projeto.clima.authentication.dto.UsersLoginRequest;
import br.com.projeto.clima.authentication.service.UsuarioResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationLoginController implements IAuthenticationLoginController {

    private final UsuarioResourceService service;

    @PostMapping("auth/login")
    public ResponseEntity<TokenResponse> tokenResponse(@RequestBody UsersLoginRequest request) {
        TokenResponse token = service.authenticateUser(request);
        return ResponseEntity.ok(token);
    }
}
