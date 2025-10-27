package br.com.projeto.clima.historico.database.domain.astro;

import br.com.projeto.clima.historico.database.domain.current.CurrentWeather;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Astro {

    @Id
    private Long id;

    @Column(nullable = false)
    private String sunrise;

    @Column(nullable = false)
    private String sunset;

    @Column(nullable = false)
    private String moonrise;

    @Column(nullable = false)
    private String moonset;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MoonPhase moonPhase;

    @OneToOne
    @MapsId
    @JoinColumn(name = "current_weather_id", nullable = false)
    private CurrentWeather currentWeather;

}
