package br.com.projeto.clima.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 12)
    private String password;
}
