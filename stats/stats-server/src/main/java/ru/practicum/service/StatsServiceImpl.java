package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.StatsEntry;
import ru.practicum.StatsRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatsServiceImpl implements StatsService {
    private final StatsRepository repository;

    @Override
    @Transactional
    public StatsEntry hit(StatsEntry entryDto) {
        log.debug("Запрос на сохранение в статистику: app = {}, uri = {}, ip = {}",
                entryDto.getApp(), entryDto.getUri(), entryDto.getIp());
        // TODO мапинг дто в сущность
        repository.save(entryDto);

        log.info("Сохранена запись в статистику: app = {}, uri = {}, ip = {}",
                entryDto.getApp(), entryDto.getUri(), entryDto.getIp());
        return null;
    }

    @Override
    public List<StatsEntry> getStats(LocalDateTime startTime, LocalDateTime endTime, Collection<String> uris, boolean unique) {
        // TODO log.debug("Запрос на получение статистики: c {} по {}", startTime, endTime);
        return null;
    }
}
