package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.Stat;
import ru.practicum.StatsEntry;
import ru.practicum.StatsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatsServiceImpl implements StatsService {
    private final StatsRepository repository;

    @Override
    @Transactional
    public StatsEntry hit(StatsEntry entryDto) {
        log.debug("Запрос на сохранение в статистику: app = {}, uri = {}, ip = {}, timestamp = {}",
                entryDto.getApp(), entryDto.getUri(), entryDto.getIp(), entryDto.getTimestamp());
        // TODO мапинг дто в сущность
        repository.save(entryDto);

        log.info("Сохранена запись в статистику: app = {}, uri = {}, ip = {}, timestamp = {}",
                entryDto.getApp(), entryDto.getUri(), entryDto.getIp(), entryDto.getTimestamp());
        return entryDto;
    }

    @Override
    public List<Stat> getStats(LocalDateTime startTime, LocalDateTime endTime, List<String> uris, boolean unique) {
        log.debug("Запрос на получение статистики c {} по {}, фильтр по uri: {}, уникальный ip: {}",
                startTime, endTime, uris, unique);

        if (unique && uris != null) {
            return repository.getStatsByUrisUniqueIp(startTime, endTime, uris);
        } else if (!unique && uris != null) {
            return repository.getStatsByUris(startTime, endTime, uris);
        } else if (unique) {
            return repository.getStatsUniqueIp(startTime, endTime);
        } else return repository.getStats(startTime, endTime);
    }
}
