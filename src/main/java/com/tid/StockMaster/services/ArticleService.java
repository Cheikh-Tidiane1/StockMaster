package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.dto.LigneCommandeClientDto;
import com.tid.StockMaster.dto.LigneCommandeFournisseurDto;
import com.tid.StockMaster.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save (ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String codeArticle);
    Iterable<ArticleDto> findAll();
    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);
    List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);
    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);
    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
    void deleteById(Integer id);
}
