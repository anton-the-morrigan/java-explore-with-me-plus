package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.dto.compilation.CompilationDto;
import ru.practicum.dto.compilation.NewCompilationDto;
import ru.practicum.entity.Compilation;
import ru.practicum.error.exception.NotFoundException;
import ru.practicum.error.exception.ValidationException;
import ru.practicum.mapper.CompilationMapper;
import ru.practicum.repository.CompilationRepository;
import ru.practicum.service.CompilationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {
    private final CompilationRepository compilationRepository;
    private final CompilationMapper compilationMapper;

    public CompilationDto addCompilation(NewCompilationDto newCompilationDto) {
        if (newCompilationDto.getTitle() == null) {
            throw new ValidationException("Название подборки не может быть null");
        }
        Compilation compilation = compilationMapper.toCompilation(newCompilationDto);
        CompilationValidator(compilation);
        compilationRepository.save(compilation);
        return compilationMapper.toCompilationDto(compilation);
    }

    public void deleteCompilation(Long compId) {
        compilationRepository.deleteById(compId);
    }

    public CompilationDto updateCompilation(Long compId, NewCompilationDto newCompilationDto) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new NotFoundException("Подборка не найдена"));
        if (newCompilationDto.getTitle() != null) {
            compilation.setTitle(newCompilationDto.getTitle());
        }
        if (newCompilationDto.getPinned() != null) {
            compilation.setPinned(newCompilationDto.getPinned());
        }
        if (newCompilationDto.getEvents() != null) {
            compilation.setEvents(newCompilationDto.getEvents());
        }
        CompilationValidator(compilation);
        compilationRepository.save(compilation);
        return compilationMapper.toCompilationDto(compilation);
    }

    public List<CompilationDto> getCompilations(Boolean pinned, Integer from, Integer size) {
        return compilationRepository.findByPinned(pinned, PageRequest.of(from, size)).stream().map(compilationMapper::toCompilationDto).collect(Collectors.toList());
    }

    public CompilationDto getCompilation(Long compId) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new NotFoundException("Подборка не найдена"));
        return compilationMapper.toCompilationDto(compilation);
    }

    private void CompilationValidator(Compilation compilation) {
        if (compilation.getTitle().isBlank()) {
            throw new ValidationException("Название подборки не может быть пустым");
        } else if (compilation.getTitle().length() > 50) {
            throw new ValidationException("Длина названия подборки не может быть больше 50 символов");
        }
    }
}
