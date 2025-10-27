package br.com.projeto.clima.usuario.service.usuario.implementation;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import br.com.projeto.clima.usuario.database.repositories.UsuarioRepository;
import br.com.projeto.clima.usuario.dto.UserLoginEmail;
import br.com.projeto.clima.usuario.dto.UserLoginRequest;
import br.com.projeto.clima.usuario.handler.exceptions.ValidationFailedException;
import br.com.projeto.clima.usuario.service.usuario.IUsuarioValidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioValidateService implements IUsuarioValidateService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserLoginEmail usuarioValidate(UserLoginRequest request) {
        log.info("validate user");
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalStateException("User not found"));

        if(encoder.matches(request.getPassword(), usuario.getPassword())){
            return UserLoginEmail.builder()
                    .email(request.getEmail())
                    .build();
        }
        throw new ValidationFailedException("Login validation failed");
    }
}
