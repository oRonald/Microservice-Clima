package br.com.projeto.clima.usuario.infrastructure;

import br.com.projeto.clima.usuario.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
