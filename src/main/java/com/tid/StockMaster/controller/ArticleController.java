package com.tid.StockMaster.controller;

import com.tid.StockMaster.controller.api.ArticleApi;
import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.dto.LigneCommandeClientDto;
import com.tid.StockMaster.dto.LigneCommandeFournisseurDto;
import com.tid.StockMaster.dto.LigneVenteDto;
import com.tid.StockMaster.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService  ) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<ArticleDto> save(ArticleDto articleDto) {
        return ResponseEntity.ok(articleService.save(articleDto));
    }

    @Override
    public ResponseEntity<ArticleDto> findById(Integer id) {
        return ResponseEntity.ok(articleService.findById(id));
    }

    @Override
    public ResponseEntity<ArticleDto> findByCodeArticle(String codeArticle) {
        return ResponseEntity.ok(articleService.findByCodeArticle(codeArticle));
    }

    @Override
    public ResponseEntity<Iterable<ArticleDto>> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        articleService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return articleService.findHistoriqueVentes(idArticle);
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {
        return articleService.findHistoriqueCommandeClient(idArticle);
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return articleService.findHistoriqueCommandeFournisseur(idArticle);
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleService.findAllArticleByIdCategory(idCategory);
    }
}
