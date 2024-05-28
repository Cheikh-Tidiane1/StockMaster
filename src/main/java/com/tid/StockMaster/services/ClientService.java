package com.tid.StockMaster.services;

import com.tid.StockMaster.dto.ClientDto;

public interface ClientService {

  ClientDto save(ClientDto dto);

  ClientDto findById(Integer id);

  Iterable<ClientDto> findAll();

  void delete(Integer id);

}
