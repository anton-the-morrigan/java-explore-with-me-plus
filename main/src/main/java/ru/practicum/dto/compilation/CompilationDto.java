package ru.practicum.dto.compilation;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.entity.Event;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompilationDto {
    Long id;

    @NotBlank
    String title;

    @NotBlank
    Boolean pinned;

    Set<Event> events;
}
