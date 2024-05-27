package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save (ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String codeArticle);
    Iterable<ArticleDto> findAll();
    void deleteById(Integer id);
}
