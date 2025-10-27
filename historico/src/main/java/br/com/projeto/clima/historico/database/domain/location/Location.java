package br.com.projeto.clima.historico.database.domain.location;

import br.com.projeto.clima.historico.database.domain.current.CurrentWeather;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cityName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDateTime requestTime;

    @Column(nullable = false)
    private LocalDateTime localTime;

    @Column(nullable = false)
    private String timeZoneId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "location")
    private CurrentWeather currentWeather;
}
