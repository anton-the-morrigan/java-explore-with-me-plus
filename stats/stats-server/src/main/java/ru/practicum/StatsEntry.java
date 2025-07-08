package ru.practicum;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "stats")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StatsEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "app")
    private String app;

    @Column(name = "uri")
    private String uri;

    @Column(name = "ip")
    private String ip;

    @Column(name = "created")
    private final LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
}
