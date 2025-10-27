package br.com.projeto.clima.historico.database.repositories;

import br.com.projeto.clima.historico.database.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
