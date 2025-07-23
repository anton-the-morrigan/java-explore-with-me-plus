package ru.practicum.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.dto.compilation.CompilationDto;
import ru.practicum.dto.compilation.NewCompilationDto;
import ru.practicum.entity.Compilation;

@Component
public class CompilationMapper {

    public Compilation toCompilation(NewCompilationDto newCompilationDto) {
        return new Compilation(null, newCompilationDto.getTitle(), newCompilationDto.getPinned(), newCompilationDto.getEvents());
    }

    public CompilationDto toCompilationDto(Compilation compilation) {
        return new CompilationDto(compilation.getId(), compilation.getTitle(), compilation.getPinned(), compilation.getEvents());
    }
}
