package br.com.projeto.clima.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationRequest {

    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(max = 12)
    private String password;
    @NotNull
    private String street;
    @NotNull
    private String neighborhood;
    @NotNull
    private String city;
}
