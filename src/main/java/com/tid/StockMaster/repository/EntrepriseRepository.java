package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
