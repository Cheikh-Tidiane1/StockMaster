package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.ChangerMdpUserDto;
import com.tid.StockMaster.dto.UtilisateurDto;

public interface UtilisateurService {

  UtilisateurDto save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  Iterable<UtilisateurDto> findAll();

  void delete(Integer id);

  UtilisateurDto findByEmail(String email);

  UtilisateurDto changerMotDePasse(ChangerMdpUserDto dto);


}
