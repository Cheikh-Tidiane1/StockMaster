package com.tid.StockMaster.controller;

import com.tid.StockMaster.controller.api.CategoryApi;
import com.tid.StockMaster.dto.CategoryDto;
import com.tid.StockMaster.services.CategoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public Iterable<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return categoryService.findByCode(code);
    }
}
