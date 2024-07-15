package com.tid.StockMaster.services.impl;

import com.tid.StockMaster.dto.CategoryDto;
import com.tid.StockMaster.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void saveCategoryWithSuccess() {

        CategoryDto categoryDto = CategoryDto.builder()
                .code("category test")
                .designation("designation test")
                .idEntreprise(1).build();
        CategoryDto savedCategory = categoryService.save(categoryDto);
        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals("category test", savedCategory.getCode());
        assertEquals("designation test", savedCategory.getDesignation());
        assertEquals(categoryDto.getIdEntreprise(), savedCategory.getIdEntreprise());
    }

}