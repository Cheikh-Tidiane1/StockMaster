package com.tid.StockMaster.services;
import com.tid.StockMaster.dto.CommandeFournisseurDto;
import com.tid.StockMaster.dto.FournisseurDto;
import com.tid.StockMaster.model.EtatCommande;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save (CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
    CommandeFournisseurDto findById(Integer id);
    CommandeFournisseurDto findByCode(String code);
    Iterable<CommandeFournisseurDto> findAll();
    void deleteById(Integer id);
}
