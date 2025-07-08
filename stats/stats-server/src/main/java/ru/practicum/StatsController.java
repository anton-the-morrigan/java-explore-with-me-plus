package ru.practicum;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.service.StatsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class StatsController {
    private final StatsService statsService;

    // TODO dto
    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.CREATED)
    public StatsEntry createNewStatEntry(@RequestBody StatsEntry entryDto) {
        return statsService.hit(entryDto);
    }

    // TODO dto
    @GetMapping("/stats")
    public List<StatsEntry> getStats(@RequestParam LocalDateTime start,
                                     @RequestParam LocalDateTime end,
                                     @RequestParam(defaultValue = "null") Set<String> uris,
                                     @RequestParam(defaultValue = "false") boolean unique) {
        return statsService.getStats(start, end, uris, unique);
    }
}
