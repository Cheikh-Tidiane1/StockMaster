package com.tid.StockMaster.repository;


import com.tid.StockMaster.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

}
