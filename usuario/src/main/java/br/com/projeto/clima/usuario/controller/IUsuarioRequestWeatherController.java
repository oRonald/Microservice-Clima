package br.com.projeto.clima.usuario.controller;

import br.com.projeto.clima.usuario.dto.RequestIdReturn;
import br.com.projeto.clima.usuario.dto.UserWeatherRequest;
import br.com.projeto.clima.usuario.dto.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
public interface IUsuarioRequestWeatherController {

    ResponseEntity<WeatherResponse> getResponse(@PathVariable String requestId);
    ResponseEntity<RequestIdReturn> requestWeather(@RequestBody @Valid UserWeatherRequest request) throws JsonProcessingException;
}
