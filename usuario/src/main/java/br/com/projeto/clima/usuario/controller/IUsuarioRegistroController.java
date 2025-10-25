package br.com.projeto.clima.usuario.controller;

import br.com.projeto.clima.usuario.dto.UserRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
public interface IUsuarioRegistroController {

    ResponseEntity<Void> userRegister(@Valid UserRegistrationRequest request);
}
