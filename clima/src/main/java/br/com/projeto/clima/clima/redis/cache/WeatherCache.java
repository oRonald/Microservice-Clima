package br.com.projeto.clima.clima.redis.cache;

import br.com.projeto.clima.clima.dto.WeatherResponse;

public interface WeatherCache {

    WeatherResponse get(String city);
    void put(String city, WeatherResponse response);
}
