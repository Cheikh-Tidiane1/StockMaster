package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface articleRepository extends JpaRepository<Article, Integer> {
}
