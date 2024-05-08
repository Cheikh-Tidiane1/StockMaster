package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
