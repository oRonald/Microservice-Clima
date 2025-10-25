package br.com.projeto.clima.usuario.service.usuario;

import br.com.projeto.clima.usuario.dto.UserRegistrationRequest;

public interface IUsuarioRegistroService {

    void registerUsers(UserRegistrationRequest request);
}
