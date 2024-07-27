package com.tid.StockMaster.services.impl;

import com.tid.StockMaster.dto.CategoryDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.exception.InvalidOperationException;
import com.tid.StockMaster.model.Article;
import com.tid.StockMaster.repository.ArticleRepository;
import com.tid.StockMaster.repository.CategoryRepository;
import com.tid.StockMaster.services.CategoryService;
import com.tid.StockMaster.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;
    public CategoryImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.categoryValidator(categoryDto);
        if (!errors.isEmpty()) {
            log.error("Category is not valid: {}", categoryDto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public Iterable<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream().map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null ){
            log.error("Category id is null");
            return null;
        }

       return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun categorie avec l'ID = " + id + " n'a ete trouve dans la BDD", ErrorCodes.CATEGORY_NOT_FOUND) );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Category code is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto::fromEntity).orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public void delete(Integer id) {
        if(id == null ){
            log.error("Category id is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(id);
    }
}
