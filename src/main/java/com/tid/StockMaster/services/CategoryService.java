package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    Iterable<CategoryDto> findAll();
    CategoryDto findById(Integer id);
    void delete(Integer id);

}
