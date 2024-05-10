package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save (ArticleDto articleDto);
        ArticleDto findById(Integer id);
    List<ArticleDto> findAll();
    void deleteById(long id);
}
