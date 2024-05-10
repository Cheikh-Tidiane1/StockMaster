package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

}
