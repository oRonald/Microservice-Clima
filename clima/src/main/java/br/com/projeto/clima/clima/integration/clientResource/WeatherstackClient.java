package br.com.projeto.clima.clima.integration.clientResource;

import br.com.projeto.clima.clima.dto.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "weatherstack-client",
        url = "http://api.weatherstack.com")
public interface WeatherstackClient {

    @GetMapping("/current")
    WeatherResponse getCurrentWeather(
            @RequestParam("access_key") String apiKey,
            @RequestParam("query") String city);
}
