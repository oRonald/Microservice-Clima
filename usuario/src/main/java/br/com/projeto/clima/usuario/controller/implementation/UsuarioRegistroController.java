package br.com.projeto.clima.usuario.controller.implementation;

import br.com.projeto.clima.usuario.controller.IUsuarioRegistroController;
import br.com.projeto.clima.usuario.dto.UserRegistrationRequest;
import br.com.projeto.clima.usuario.service.usuario.IUsuarioRegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioRegistroController implements IUsuarioRegistroController {

    private final IUsuarioRegistroService iUsuarioRegistroService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> userRegister(@RequestBody UserRegistrationRequest request) {
        iUsuarioRegistroService.registerUsers(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
