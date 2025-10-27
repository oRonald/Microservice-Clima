package br.com.projeto.clima.usuario.controller.implementation;

import br.com.projeto.clima.usuario.controller.IUsuarioValidarController;
import br.com.projeto.clima.usuario.dto.UserLoginEmail;
import br.com.projeto.clima.usuario.dto.UserLoginRequest;
import br.com.projeto.clima.usuario.service.usuario.implementation.UsuarioValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios/validate")
@RequiredArgsConstructor
public class UsuarioValidarController implements IUsuarioValidarController {

    private final UsuarioValidateService service;

    @PostMapping
    public ResponseEntity<UserLoginEmail> validarUsuario(UserLoginRequest request) {
        return ResponseEntity.ok(service.usuarioValidate(request));
    }
}
