package br.com.projeto.clima.clima.redis.cache.implementation;

import br.com.projeto.clima.clima.redis.cache.WeatherCache;
import br.com.projeto.clima.clima.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisWeatherCache implements WeatherCache {

    private final RedisTemplate<String, WeatherResponse> redisTemplate;

    @Value("${cache.weather.ttl-minutes}")
    private long ttlMinutes;

    public RedisWeatherCache(RedisTemplate<String, WeatherResponse> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public WeatherResponse get(String city) {
        return redisTemplate.opsForValue().get(city);
    }

    @Override
    public void put(String city, WeatherResponse response) {
        redisTemplate.opsForValue().set(city, response, Duration.ofMinutes(ttlMinutes));
    }
}
