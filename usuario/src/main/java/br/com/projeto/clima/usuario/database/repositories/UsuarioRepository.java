package br.com.projeto.clima.usuario.database.repositories;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
}
