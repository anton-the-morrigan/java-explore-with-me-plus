package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import ru.practicum.dto.compilation.CompilationDto;
import ru.practicum.dto.compilation.NewCompilationDto;
import ru.practicum.repository.CompilationRepository;
import ru.practicum.service.CompilationService;

import java.util.List;

@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {
    private final CompilationRepository compilationRepository;

    public CompilationDto addCompilation(NewCompilationDto newCompilationDto) {

    }

    public void deleteCompilation(Long compId) {

    }

    public CompilationDto updateCompilation(Long compId, NewCompilationDto newCompilationDto) {

    }

    public List<CompilationDto> getCompilations() {

    }

    public CompilationDto getCompilation(Long compId) {

    }
}
