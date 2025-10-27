package br.com.projeto.clima.authentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsersLoginRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 12)
    private String password;
}
