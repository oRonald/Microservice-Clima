package br.com.projeto.clima.usuario.database.infrastructure;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
