package br.com.projeto.clima.usuario.service.usuario;

import br.com.projeto.clima.usuario.dto.UserLoginEmail;
import br.com.projeto.clima.usuario.dto.UserLoginRequest;

public interface IUsuarioValidateService {

    UserLoginEmail usuarioValidate(UserLoginRequest request);
}
