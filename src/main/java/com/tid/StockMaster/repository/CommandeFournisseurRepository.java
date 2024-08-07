package com.tid.StockMaster.repository;
import com.tid.StockMaster.model.CommandeClient;
import com.tid.StockMaster.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
    List<CommandeClient> findAllByFournisseurId(Integer id);
}
