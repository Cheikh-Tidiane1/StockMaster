package com.tid.StockMaster.controller.api;

import com.tid.StockMaster.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(path = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save (@RequestBody ArticleDto articleDto);
    @GetMapping(path = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);
    @GetMapping(path = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
    @GetMapping(path = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<ArticleDto> findAll();
    @DeleteMapping(path = APP_ROOT + "/articles/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(@PathVariable("idArticle") Integer id);
}
