package br.com.projeto.clima.authentication.application;

import br.com.projeto.clima.authentication.dto.TokenResponse;
import br.com.projeto.clima.authentication.dto.UsersLoginRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationLoginController {

    ResponseEntity<TokenResponse> tokenResponse(UsersLoginRequest request);
}
