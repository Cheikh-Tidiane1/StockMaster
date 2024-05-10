package com.tid.StockMaster.services.impl;

import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.repository.ArticleRepository;
import com.tid.StockMaster.services.ArticleService;
import com.tid.StockMaster.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(long id) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(long id) {

    }
}
