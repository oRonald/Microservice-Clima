package br.com.projeto.clima.usuario.database.repositories;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(@Email @NotBlank String email);
}
