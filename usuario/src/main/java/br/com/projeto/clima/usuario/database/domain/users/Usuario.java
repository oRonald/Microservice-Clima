package br.com.projeto.clima.usuario.database.domain.users;

import br.com.projeto.clima.usuario.database.domain.endereco.Endereco;
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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 60)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Endereco address;
}
