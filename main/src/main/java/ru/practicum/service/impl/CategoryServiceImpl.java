package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.dto.category.CategoryDto;
import ru.practicum.dto.category.NewCategoryDto;
import ru.practicum.entity.Category;
import ru.practicum.exception.NotFoundException;
import ru.practicum.mapper.CategoryMapper;
import ru.practicum.repository.CategoryRepository;
import ru.practicum.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto addCategory(NewCategoryDto newCategoryDto) {
        Category category = categoryMapper.toCategory(newCategoryDto);
        categoryRepository.save(category);
        return categoryMapper.toCategoryDto(category);
    }

    public void deleteCategory(Long catId) {
        categoryRepository.deleteById(catId);
    }

    public CategoryDto updateCategory(Long catId, NewCategoryDto newCategoryDto) {
        Category category = categoryRepository.findById(catId).orElseThrow(() -> new NotFoundException("Категория не найдена"));
        if (newCategoryDto.getName() != null) {
            category.setName(newCategoryDto.getName());
        }
        if (newCategoryDto.getEvents() != null) {
            category.setEvents(newCategoryDto.getEvents());
        }
        categoryRepository.save(category);
        return categoryMapper.toCategoryDto(category);
    }

    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto getCategory(Long catId) {
        Category category = categoryRepository.findById(catId).orElseThrow(() -> new NotFoundException("Категория не найдена"));
        return categoryMapper.toCategoryDto(category);
    }
}
