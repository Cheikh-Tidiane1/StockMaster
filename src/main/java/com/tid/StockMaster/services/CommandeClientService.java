package com.tid.StockMaster.services;
import com.tid.StockMaster.dto.CommandeClientDto;

public interface CommandeClientService {
    CommandeClientDto save (CommandeClientDto commandeClientDto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCode(String code);
    Iterable<CommandeClientDto> findAll();
    void deleteById(Integer id);
}
