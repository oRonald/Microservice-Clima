package br.com.projeto.clima.usuario.service.usuario;

import br.com.projeto.clima.usuario.dto.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IUsuarioClimateService {

    String sendUsersCity(@RequestHeader("Authorization") String authorization) throws JsonProcessingException;
    WeatherResponse getCachedResponse(String requestId);

    void putResponse(String requestId, WeatherResponse response);
}
