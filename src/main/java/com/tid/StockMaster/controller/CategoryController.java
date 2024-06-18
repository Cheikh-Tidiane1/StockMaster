package com.tid.StockMaster.controller;

import com.tid.StockMaster.controller.api.CategoryApi;
import com.tid.StockMaster.dto.CategoryDto;
import com.tid.StockMaster.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    public ResponseEntity<CategoryDto> save(CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @Override
    public ResponseEntity<Iterable<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity<CategoryDto> findById(Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CategoryDto> findByCode(String code) {
        return ResponseEntity.ok(categoryService.findByCode(code));
    }
}
