package com.tid.StockMaster.repository;


import com.tid.StockMaster.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
    Optional<CommandeClient> findCommandeClientByCode(String code);
    List<CommandeClient> findAllByClientId(Integer id);
}
