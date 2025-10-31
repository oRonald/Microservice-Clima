package br.com.projeto.clima.usuario.service.usuario.implementation;

import br.com.projeto.clima.usuario.database.domain.users.Usuario;
import br.com.projeto.clima.usuario.database.repositories.UsuarioRepository;
import br.com.projeto.clima.usuario.dto.ClientDataPublish;
import br.com.projeto.clima.usuario.dto.WeatherResponse;
import br.com.projeto.clima.usuario.handler.exceptions.EmailDoesNotExistsException;
import br.com.projeto.clima.usuario.service.mqueue.UsersWeatherPublisher;
import br.com.projeto.clima.usuario.service.usuario.IUsuarioClimateService;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioClimateService implements IUsuarioClimateService {

    private final UsersWeatherPublisher publisher;
    private final UsuarioRepository repository;
    private final Cache<String, WeatherResponse> responseCache = Caffeine.newBuilder()
            .maximumSize(1)
            .build();

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
        return responseCache.getIfPresent(requestId);
    }
}
