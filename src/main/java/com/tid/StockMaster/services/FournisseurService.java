package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.FournisseurDto;

public interface FournisseurService {

  FournisseurDto save(FournisseurDto dto);

  FournisseurDto findById(Integer id);

  Iterable<FournisseurDto> findAll();

  void delete(Integer id);

}
