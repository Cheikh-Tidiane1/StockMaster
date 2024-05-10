package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

}
