package com.tid.StockMaster.repository;

import com.tid.StockMaster.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
