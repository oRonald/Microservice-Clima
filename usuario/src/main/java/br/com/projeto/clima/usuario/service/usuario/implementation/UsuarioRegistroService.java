package br.com.projeto.clima.usuario.service.usuario.implementation;

import br.com.projeto.clima.usuario.database.domain.endereco.Endereco;
import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import br.com.projeto.clima.usuario.database.repositories.UsuarioRepository;
import br.com.projeto.clima.usuario.dto.UserRegistrationRequest;
import br.com.projeto.clima.usuario.handler.exceptions.EmailAlreadyExistsException;
import br.com.projeto.clima.usuario.service.usuario.IUsuarioRegistroService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioRegistroService implements IUsuarioRegistroService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void registerUsers(UserRegistrationRequest request) {
        if(usuarioRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException();
        }
        Usuario usuario = Usuario.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(Endereco.builder()
                        .street(request.getStreet())
                        .neighborhood(request.getNeighborhood())
                        .city(request.getCity())
                        .build())
                .build();

        usuario.getAddress().setUser(usuario);
        usuarioRepository.save(usuario);
        log.info("user registered successfully");
    }
}
