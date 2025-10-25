package br.com.projeto.clima.usuario.domain.endereco;

import br.com.projeto.clima.usuario.domain.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario user;
}
