package ru.practicum.params;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventUserSearchParam {
    private Long userId;

    private Integer from;

    private Integer size;

    public Pageable getPageable() {
        int page = from / size;
        return PageRequest.of(page, size);
    }
}
