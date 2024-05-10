package com.tid.StockMaster.repository;
import com.tid.StockMaster.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

}
