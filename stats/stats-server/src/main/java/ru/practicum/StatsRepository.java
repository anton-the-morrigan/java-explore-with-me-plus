package ru.practicum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository extends JpaRepository<StatsEntry, Long> {

/*    TODO:
    1. Полная статистика
    2. Статистика для указанных ip
    3. Уникальность
    */
/*    @Query("""
            select new ru.practicum.Stats(s.app, s.uri, count)
            from StatsEntry as s group by s.uri
            where s.created >= ?1 and s.created < ?2""")
    List<StatsEntry> getStats(LocalDateTime start, LocalDateTime end);*/
}
