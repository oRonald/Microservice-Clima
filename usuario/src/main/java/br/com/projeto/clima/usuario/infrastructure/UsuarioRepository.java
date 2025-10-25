package br.com.projeto.clima.usuario.infrastructure;

import br.com.projeto.clima.usuario.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
