package br.com.projeto.clima.usuario.service.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IUsuarioClimateService {

    ResponseEntity<?> getPerfil(@RequestHeader("Authorization") String authorization);
}
