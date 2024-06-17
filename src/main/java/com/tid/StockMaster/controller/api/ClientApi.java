package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface ClientApi {

  @PostMapping(path = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Enregistre un client", description = "Cette méthode permet d'enregistrer ou modifier un client")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "L'objet client cree / modifie"),
          @ApiResponse(responseCode = "400",description = "L'objet client n'est pas valide")
  })
  ClientDto save(@RequestBody ClientDto dto);

  @GetMapping(path = APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Rechercher un client par ID" , description = "Cette méthode permet de chercher un client par son ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "Le client a été trouve dans la BDD"),
          @ApiResponse(responseCode = "404",description = "Aucun client n'existe dans la BDD avec l'Id fourni")
  })
  ClientDto findById(@PathVariable("idClient") Integer id);

  @GetMapping(path = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Renvoi la liste des clients" , description = "Cette méthode permet de chercher et renvoyer la liste des clients qui existent dans la BDD")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "La liste des clients / Une liste vide")
  })
  Iterable<ClientDto> findAll();

  @DeleteMapping(path = APP_ROOT + "/clients/delete/{idClient}")
  @Operation(summary = "Supprime un client" , description = "Cette méthode permet de supprimer un client par ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",description = "Le client  a été supprime")
  })
  void delete(@PathVariable("idClient") Integer id);

}
