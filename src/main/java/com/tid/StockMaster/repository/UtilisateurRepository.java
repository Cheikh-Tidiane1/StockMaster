package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
