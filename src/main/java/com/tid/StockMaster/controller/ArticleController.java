package com.tid.StockMaster.controller;

import com.tid.StockMaster.controller.api.ArticleApi;
import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService  ) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public Iterable<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        articleService.deleteById(id);
    }
}
