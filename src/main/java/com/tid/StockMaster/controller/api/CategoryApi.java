package com.tid.StockMaster.controller.api;

import com.tid.StockMaster.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(path = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(path = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<CategoryDto> findAll();

    @GetMapping(path = APP_ROOT + "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("categoryId") Integer id);

    @DeleteMapping(path = APP_ROOT + "/categories/delete/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("categoryId") Integer id);

    @GetMapping(path = APP_ROOT + "/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("codeCategory") String code);

}
