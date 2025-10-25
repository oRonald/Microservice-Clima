package br.com.projeto.clima.usuario.database.repositories;

import br.com.projeto.clima.usuario.database.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
