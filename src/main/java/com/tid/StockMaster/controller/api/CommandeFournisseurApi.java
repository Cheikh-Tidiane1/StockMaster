package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.CommandeFournisseurDto;
import com.tid.StockMaster.dto.LigneCommandeFournisseurDto;
import com.tid.StockMaster.model.EtatCommande;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface CommandeFournisseurApi {

    @PostMapping(APP_ROOT + "/commandesfournisseurs/create")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/{idCommandeFournisseur}")
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/filter/{codeCommandeFournisseur}")
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/all")
    Iterable<CommandeFournisseurDto> findAll();

    @DeleteMapping(APP_ROOT + "/commandesfournisseurs/delete/{idCommandeFournisseur}")
    void delete(@PathVariable("idCommandeFournisseur") Integer id);

    @PatchMapping(APP_ROOT + "/update/etat/{idCommande}/{etatCommande}")
    CommandeFournisseurDto updateEtatCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping(APP_ROOT + "/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    CommandeFournisseurDto updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
                                                  @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping(APP_ROOT + "/update/fournisseur/{idCommande}/{idFournisseur}")
    CommandeFournisseurDto updateFournisseur(@PathVariable("idCommande") Integer idCommande, @PathVariable("idFournisseur") Integer idFournisseur);

    @PatchMapping(APP_ROOT + "/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    CommandeFournisseurDto updateArticle(@PathVariable("idCommande") Integer idCommande,
                                         @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("idArticle") Integer idArticle);

    @DeleteMapping(APP_ROOT + "/delete/article/{idCommande}/{idLigneCommande}")
    CommandeFournisseurDto deleteArticle(@PathVariable("idCommande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande);

    @GetMapping(APP_ROOT + "/lignesCommande/{idCommande}")
    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(@PathVariable("idCommande") Integer idCommande);
}
