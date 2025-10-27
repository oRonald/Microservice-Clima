package br.com.projeto.clima.usuario.controller;

import br.com.projeto.clima.usuario.dto.UserLoginEmail;
import br.com.projeto.clima.usuario.dto.UserLoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
public interface IUsuarioValidarController {
    ResponseEntity<UserLoginEmail> validarUsuario(@RequestBody @Valid UserLoginRequest request);
}
