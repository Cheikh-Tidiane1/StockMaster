package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer> {
    List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Integer idCommande);
    List<LigneCommandeFournisseur> findAllByArticleId(Integer idCommande);
}
