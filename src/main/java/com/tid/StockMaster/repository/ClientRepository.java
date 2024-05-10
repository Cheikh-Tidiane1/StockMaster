package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
