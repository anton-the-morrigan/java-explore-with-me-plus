package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import ru.practicum.dto.category.CategoryDto;
import ru.practicum.dto.category.NewCategoryDto;
import ru.practicum.repository.CategoryRepository;
import ru.practicum.service.CategoryService;

import java.util.List;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto addCategory(NewCategoryDto newCategoryDto) {

    }

    public void deleteCategory(Long catId) {

    }

    public CategoryDto updateCategory(Long catId, NewCategoryDto newCategoryDto) {

    }

    public List<CategoryDto> getCategories() {

    }

    public CategoryDto getCategory(Long catId) {

    }
}
