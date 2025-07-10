package ru.practicum.service;

import ru.practicum.Stat;
import ru.practicum.StatsEntry;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {
    StatsEntry hit(StatsEntry entryDto);

    List<Stat> getStats(LocalDateTime startTime, LocalDateTime endTime, List<String> uris, boolean unique);
}
