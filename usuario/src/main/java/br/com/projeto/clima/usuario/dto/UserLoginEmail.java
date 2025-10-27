package br.com.projeto.clima.usuario.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginEmail {

    private String email;
}
