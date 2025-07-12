package ru.practicum.stats;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.practicum.dto.EndpointHitDto;

import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Long id;

    @Column(name = "app")
    String app;

    @Column(name = "uri")
    String uri;

    @Column(name = "ip")
    String ip;

    @Column(name = "created")
    LocalDateTime timestamp;

    public static StatsEntry fromDto(EndpointHitDto dto) {
        StatsEntry entry = new StatsEntry();
        entry.setApp(dto.getApp());
        entry.setUri(dto.getUri());
        entry.setIp(dto.getIp());
        entry.setTimestamp(dto.getTimestamp());
        return entry;
    }
}
