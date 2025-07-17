package ru.practicum.dto.compilation;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.entity.Event;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompilationDto {
    Long id;

    @NotBlank
    Boolean pinned;

    @NotBlank
    String title;

    List<Event> events;
}
