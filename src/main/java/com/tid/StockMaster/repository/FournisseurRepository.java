package com.tid.StockMaster.repository;
import com.tid.StockMaster.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
