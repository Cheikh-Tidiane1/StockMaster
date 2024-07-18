package com.tid.StockMaster.services;
import com.tid.StockMaster.dto.CommandeClientDto;
import com.tid.StockMaster.model.EtatCommande;

import java.math.BigDecimal;

public interface CommandeClientService {
    CommandeClientDto save (CommandeClientDto commandeClientDto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCode(String code);
    Iterable<CommandeClientDto> findAll();
    void deleteById(Integer id);
    CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
    CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);
    CommandeClientDto updateClient(Integer idCommande, Integer idClient);
    CommandeClientDto updateArticle(Integer idCommande,Integer idLigneCommande, Integer idArticle);


}
