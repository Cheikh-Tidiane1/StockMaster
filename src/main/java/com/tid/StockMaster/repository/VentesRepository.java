package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Integer> {

}
