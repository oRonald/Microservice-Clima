package br.com.projeto.clima.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserWeatherRequest {

    @Email
    @NotBlank
    String email;
}
