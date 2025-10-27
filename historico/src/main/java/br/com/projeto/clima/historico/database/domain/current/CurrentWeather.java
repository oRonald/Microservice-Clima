package br.com.projeto.clima.historico.database.domain.current;

import br.com.projeto.clima.historico.database.domain.astro.Astro;
import br.com.projeto.clima.historico.database.domain.location.Location;
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
public class CurrentWeather {

    @Id
    private Long id;

    @Column(nullable = false)
    private Integer temperature;

    @Column(nullable = false)
    private String weatherDescription;

    @Column(nullable = false)
    private Integer windSpeed;

    @Column(nullable = false)
    private Integer precipitation;

    @Column(nullable = false)
    private Integer feelsLike;

    @Column(nullable = false)
    private Boolean isDay;

    @OneToOne
    @MapsId
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToOne(mappedBy = "currentWeather", cascade = CascadeType.ALL)
    private Astro astro;
}
