package br.com.projeto.clima.usuario.service.usuario.implementation;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import br.com.projeto.clima.usuario.database.repositories.UsuarioRepository;
import br.com.projeto.clima.usuario.dto.ClientDataPublish;
import br.com.projeto.clima.usuario.dto.WeatherResponse;
import br.com.projeto.clima.usuario.handler.exceptions.EmailDoesNotExistsException;
import br.com.projeto.clima.usuario.service.mqueue.UsersWeatherPublisher;
import br.com.projeto.clima.usuario.service.usuario.IUsuarioClimateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UsuarioClimateService implements IUsuarioClimateService {

    private final UsersWeatherPublisher publisher;
    private final UsuarioRepository repository;
    private final Map<String, WeatherResponse> responseCache = new ConcurrentHashMap<>();

    public UsuarioClimateService(UsersWeatherPublisher publisher, UsuarioRepository repository) {
        this.publisher = publisher;
        this.repository = repository;
    }

    @Override
    public String sendUsersCity(String authorization) {
        Usuario usuario = repository.findByEmail(authorization).orElseThrow(EmailDoesNotExistsException::new);

        String requestId = UUID.randomUUID().toString();

        publisher.requestWeather(ClientDataPublish.builder()
                .cityName(usuario.getAddress().getCity())
                .requestId(requestId)
                .build());

        return requestId;
    }

    @Override
    public void putResponse(String requestId, WeatherResponse response) {
        responseCache.put(requestId, response);
    }

    @Override
    public WeatherResponse getCachedResponse(String requestId) {
        return responseCache.get(requestId);
    }
}
