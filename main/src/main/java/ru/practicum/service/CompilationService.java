package ru.practicum.service;

import ru.practicum.dto.compilation.CompilationDto;
import ru.practicum.dto.compilation.NewCompilationDto;

import java.util.List;

public interface CompilationService {

    CompilationDto addCompilation(NewCompilationDto newCompilationDto);

    void deleteCompilation(Long compId);

    CompilationDto updateCompilation(Long compId, NewCompilationDto newCompilationDto);

    List<CompilationDto> getCompilations();

    CompilationDto getCompilation(Long compId);
}
