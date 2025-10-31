package br.com.projeto.clima.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse implements Serializable {

    private Location location;
    private CurrentWeather current;

    private String requestId;

    @Data
    public static class Location implements Serializable {

        @JsonProperty("name")
        private String cityName;

        private String country;

        @JsonProperty("timezone_id")
        private String timeZoneId;

        @JsonProperty("localtime")
        private String localTime;
    }

    @Data
    public static class CurrentWeather implements Serializable {

        private Integer temperature;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        @JsonProperty("wind_speed")
        private Integer windSpeed;

        @JsonProperty("precip")
        private Integer precipitation;

        @JsonProperty("feelslike")
        private Integer feelsLike;

        @JsonProperty("is_day")
        private String isDayRaw;
    }
}
