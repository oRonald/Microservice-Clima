package br.com.projeto.clima.usuario.service.usuario.implementation;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import br.com.projeto.clima.usuario.database.repositories.UsuarioRepository;
import br.com.projeto.clima.usuario.service.usuario.IUsuarioClimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class UsuarioClimateService implements IUsuarioClimateService {

    private final UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<?> getPerfil(String authorization) {
        String token = authorization.replace("Bearer ", "");
        return ResponseEntity.ok(token);
    }
}
