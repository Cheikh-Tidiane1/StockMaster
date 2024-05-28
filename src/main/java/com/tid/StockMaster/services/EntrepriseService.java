package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.EntrepriseDto;

public interface EntrepriseService {

  EntrepriseDto save(EntrepriseDto dto);

  EntrepriseDto findById(Integer id);

  Iterable<EntrepriseDto> findAll();

  void delete(Integer id);

}
