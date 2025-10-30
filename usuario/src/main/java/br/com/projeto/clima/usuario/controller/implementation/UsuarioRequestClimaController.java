package br.com.projeto.clima.usuario.controller.implementation;

import br.com.projeto.clima.usuario.controller.IUsuarioRequestWeatherController;
import br.com.projeto.clima.usuario.dto.RequestIdReturn;
import br.com.projeto.clima.usuario.dto.UserWeatherRequest;
import br.com.projeto.clima.usuario.dto.WeatherResponse;
import br.com.projeto.clima.usuario.service.usuario.implementation.UsuarioClimateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioRequestClimaController implements IUsuarioRequestWeatherController{

    private final UsuarioClimateService service;

    @Override
    @PostMapping("/weather")
    public ResponseEntity<RequestIdReturn> requestWeather(UserWeatherRequest request) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(RequestIdReturn.builder().requestId(service.sendUsersCity(request.getEmail())).build());
    }

    @Override
    @GetMapping("/weather/response/{requestId}")
    public ResponseEntity<WeatherResponse> getResponse(String requestId) {
        WeatherResponse response = service.getCachedResponse(requestId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
