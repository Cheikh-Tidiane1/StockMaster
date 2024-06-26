package com.tid.StockMaster.services.impl;

import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.repository.ArticleRepository;
import com.tid.StockMaster.services.ArticleService;
import com.tid.StockMaster.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
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
    public ArticleDto findById(Integer id) {
        if(id == null ){
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND
        ));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }

        return articleRepository.findArticleByCodeArticle(codeArticle).map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                "Aucun article avec le CODE = " + codeArticle + " n'a  ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND
        ));

    }

    @Override
    public Iterable<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }

        articleRepository.deleteById(id);
    }
}
