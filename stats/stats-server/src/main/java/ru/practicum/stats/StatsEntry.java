package ru.practicum.stats;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.dto.EndpointHitDto;

import java.time.LocalDateTime;

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
    private LocalDateTime timestamp;

    public static StatsEntry fromDto(EndpointHitDto dto) {
        StatsEntry entry = new StatsEntry();
        entry.setApp(dto.getApp());
        entry.setUri(dto.getUri());
        entry.setIp(dto.getIp());
        entry.setTimestamp(dto.getTimestamp());
        return entry;
    }
}
