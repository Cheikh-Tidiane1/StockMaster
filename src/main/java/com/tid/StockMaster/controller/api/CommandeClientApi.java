package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.CommandeClientDto;
import com.tid.StockMaster.model.EtatCommande;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface CommandeClientApi {

  @PostMapping(APP_ROOT + "/commandesclients/create")
  @Operation(summary = "Enregistre une commande Client", description = "Cette méthode permet d'enregistrer ou modifier une commande Client")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "Commande Client cree/ modifie"),
          @ApiResponse(responseCode = "400",description = "Commande Client n'est pas validee")
  })
  ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

  @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
  @Operation(summary = "Rechercher une commande Client par ID" , description = "Cette méthode permet de chercher une commande Client par son ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "La commande Client a été trouve dans la BDD"),
          @ApiResponse(responseCode = "404",description = "Aucune commande Client n'existe dans la BDD avec l'Id fourni")
  })
  ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

  @GetMapping(APP_ROOT + "/commandesclients/filter/{codeCommandeClient}")
  @Operation(summary = "Recherche une commande Client par CODE" , description = "Cette méthode permet de chercher une commande Client par son CODE")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "La commande Client a été trouve dans la BDD"),
          @ApiResponse(responseCode = "404",description = "Aucune commande Client n'existe dans la BDD avec le CODE fourni")
  })
  ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

  @GetMapping(APP_ROOT + "/commandesclients/all")
  @Operation(summary = "Renvoi la liste des commandes clients" , description = "Cette méthode permet de chercher et renvoyer la liste des commandes clients qui existent dans la BDD")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "La liste des commandes clients / Une liste vide")
  })
  ResponseEntity<Iterable<CommandeClientDto>> findAll();

  @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
  @Operation(summary = "Supprime une commande Client" , description = "Cette méthode permet de supprimer une commande Client par ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "La commande Client  a été supprime")
  })
  ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);

  @PatchMapping(APP_ROOT + "/commandesclients/update/etat/{idCommande}/{etatCommande}")
  ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

  @PatchMapping(APP_ROOT + "/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
  ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);

  @PatchMapping(APP_ROOT + "/commandesclients/update/client/{idCommande}/{idClient}")
  ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idCommande") Integer idCommande, @PathVariable("idClient") Integer idClient);
}
