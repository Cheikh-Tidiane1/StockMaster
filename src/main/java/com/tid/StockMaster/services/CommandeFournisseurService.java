package com.tid.StockMaster.services;
import com.tid.StockMaster.dto.CommandeFournisseurDto;
import com.tid.StockMaster.dto.FournisseurDto;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save (CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto findById(Integer id);
    CommandeFournisseurDto findByCode(String code);
    Iterable<CommandeFournisseurDto> findAll();
    void deleteById(Integer id);
}
