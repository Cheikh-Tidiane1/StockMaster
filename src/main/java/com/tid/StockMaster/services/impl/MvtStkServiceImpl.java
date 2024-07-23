package com.tid.StockMaster.services.impl;

import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.dto.MvtStkDto;
import com.tid.StockMaster.repository.MvtStkRepository;
import com.tid.StockMaster.services.ArticleService;
import com.tid.StockMaster.services.MvtStkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private MvtStkRepository mvtStkRepository;
    private ArticleService articleService;

    @Autowired
    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository, ArticleService articleService) {
        this.mvtStkRepository = mvtStkRepository;
        this.articleService = articleService;
    }

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        if (idArticle == null) {
            log.warn("ID article is NULL");
            return BigDecimal.valueOf(-1);
        }
        articleService.findById(idArticle);
        return mvtStkRepository.stockReelArticle(idArticle);

    }

    @Override
    public List<MvtStkDto> mvtStkArticle(Integer idArticle) {
        return List.of();
    }

    @Override
    public MvtStkDto entreeStock(MvtStkDto dto) {
        return null;
    }

    @Override
    public MvtStkDto sortieStock(MvtStkDto dto) {
        return null;
    }

    @Override
    public MvtStkDto correctionStockPos(MvtStkDto dto) {
        return null;
    }

    @Override
    public MvtStkDto correctionStockNeg(MvtStkDto dto) {
        return null;
    }
}
