package com.tid.StockMaster.services.impl;

import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.dto.MvtStkDto;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.repository.MvtStkRepository;
import com.tid.StockMaster.services.ArticleService;
import com.tid.StockMaster.services.MvtStkService;
import com.tid.StockMaster.validator.MvtStkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
       return mvtStkRepository.findById(idArticle).stream()
                .map(MvtStkDto::fromEntity)
               .collect(Collectors.toList());
    }

    @Override
    public MvtStkDto entreeStock(MvtStkDto dto) {
        List<String> errors = MvtStkValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid",dto);
            throw new InvalidEntityException("Le mouvement de stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID,errors);
        }
        dto.setQuantite(BigDecimal.valueOf(Math.abs(dto.getQuantite().doubleValue())));
        return MvtStkDto.fromEntity(mvtStkRepository.save(MvtStkDto.toEntity(dto)));
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
