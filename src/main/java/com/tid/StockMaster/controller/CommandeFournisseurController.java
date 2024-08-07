package com.tid.StockMaster.controller;
import com.tid.StockMaster.dto.LigneCommandeFournisseurDto;
import com.tid.StockMaster.model.EtatCommande;
import com.tid.StockMaster.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import com.tid.StockMaster.controller.api.CommandeFournisseurApi;
import com.tid.StockMaster.dto.CommandeFournisseurDto;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

   private CommandeFournisseurService commandeFournisseurService;
   @Autowired
   private CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService ){
       this.commandeFournisseurService = commandeFournisseurService;
   }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return this.commandeFournisseurService.save(dto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return this.commandeFournisseurService.findById(id);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return this.commandeFournisseurService.findByCode(code);
    }

    @Override
    public Iterable<CommandeFournisseurDto> findAll() {
        return this.commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        this.commandeFournisseurService.deleteById(id);
    }

    @Override
    public CommandeFournisseurDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return commandeFournisseurService.updateEtatCommande(idCommande, etatCommande);
    }

    @Override
    public CommandeFournisseurDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return commandeFournisseurService.updateQuantiteCommande(idCommande, idLigneCommande, quantite);
    }

    @Override
    public CommandeFournisseurDto updateFournisseur(Integer idCommande, Integer idFournisseur) {
        return commandeFournisseurService.updateFournisseur(idCommande, idFournisseur);
    }

    @Override
    public CommandeFournisseurDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
        return commandeFournisseurService.updateArticle(idCommande, idLigneCommande, idArticle);
    }

    @Override
    public CommandeFournisseurDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return commandeFournisseurService.deleteArticle(idCommande, idLigneCommande);
    }

    @Override
    public List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande) {
        return commandeFournisseurService.findAllLignesCommandesFournisseurByCommandeFournisseurId(idCommande);
    }
}
