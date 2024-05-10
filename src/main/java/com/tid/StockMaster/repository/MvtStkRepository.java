package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {


}
