package ru.practicum;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StatsClient {

    private final RestTemplate restTemplate;

    @Value("${stats.server.url}")
    private String URL;

    public void postHit(EndpointHitDto dto) {
        restTemplate.postForEntity(URL + "/hit", dto, Void.class);
    }

    public List<ViewStatsDto> getStats(String start, String end, List<String> uris, boolean unique) throws RestClientException {

        StringBuilder uri = new StringBuilder(URL).append("/stats")
                .append("?start=").append(start)
                .append("&end=").append(end)
                .append("&unique=").append(unique);

        if (!uris.isEmpty()) {
            for (String uriStr : uris) {
                uri.append("&uri=").append(uriStr);
            }
        }

        ResponseEntity<ViewStatsDto[]> response = restTemplate.getForEntity(uri.toString(), ViewStatsDto[].class);

        ViewStatsDto[] body = response.getBody();
        return (body == null) ? new ArrayList<>() : Arrays.asList(body);
    }
}