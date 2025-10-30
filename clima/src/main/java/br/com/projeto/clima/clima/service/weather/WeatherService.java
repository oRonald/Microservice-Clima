package br.com.projeto.clima.clima.service.weather;

import br.com.projeto.clima.clima.dto.ClientDataSubscriber;
import br.com.projeto.clima.clima.dto.WeatherResponse;
import br.com.projeto.clima.clima.integration.clientResource.WeatherstackClient;
import br.com.projeto.clima.clima.redis.cache.WeatherCache;
import br.com.projeto.clima.clima.service.mqueue.UsersWeatherPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private final WeatherstackClient weatherstackClient;
    private final WeatherCache cache;
    private final UsersWeatherPublisher publisher;

    @Value("${weatherstack.api-key}")
    private String apiKey;

    public void getWeatherRequest(ClientDataSubscriber subscriber) {
        WeatherResponse cacheReturn = cache.get(subscriber.getCityName());
        if (cacheReturn != null) {
            publisher.sendResponse(cacheReturn);
            return;
        }
        WeatherResponse response = weatherstackClient.getCurrentWeather(apiKey, subscriber.getCityName());
        response.setRequestId(subscriber.getRequestId());
        cache.put(subscriber.getCityName(), response);
        publisher.sendResponse(response);
    }



}
