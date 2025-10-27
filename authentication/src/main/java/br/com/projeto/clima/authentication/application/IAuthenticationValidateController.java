package br.com.projeto.clima.authentication.application;

import br.com.projeto.clima.authentication.dto.ValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IAuthenticationValidateController {

    ResponseEntity<ValidationResponse> validate(@RequestHeader("Authorization") String header);
}
