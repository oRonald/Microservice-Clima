package br.com.projeto.clima.authentication.integration;

import br.com.projeto.clima.authentication.dto.UsersLoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usuario", path = "/usuarios/validate")
public interface UsuarioResourceClient {

    @PostMapping
    UsersLoginRequest userLoginRequest(@RequestBody UsersLoginRequest request);
}
