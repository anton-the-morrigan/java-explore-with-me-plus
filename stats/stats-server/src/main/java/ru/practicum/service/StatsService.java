package ru.practicum.service;

import ru.practicum.StatsEntry;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface StatsService {
    StatsEntry hit(StatsEntry entryDto);

    List<StatsEntry> getStats(LocalDateTime startTime, LocalDateTime endTime, Collection<String> uris, boolean unique);
}
