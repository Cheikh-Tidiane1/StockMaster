package com.tid.StockMaster.controller.api;

import com.tid.StockMaster.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(path = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enregistre une catégorie", description = "Cette méthode permet d'enregistrer ou modifier une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "L'objet catégorie cree / modifie"),
            @ApiResponse(responseCode = "400",description = "L'objet catégorie n'est pas valide")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(path = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des catégories" , description = "Cette méthode permet de chercher et renvoyer la liste des catégories qui existent dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La liste des catégories / Une liste vide")
    })
    Iterable<CategoryDto> findAll();

    @GetMapping(path = APP_ROOT + "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une catégorie par ID" , description = "Cette méthode permet de chercher une catégorie par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La catégorie a été trouve dans la BDD"),
            @ApiResponse(responseCode = "404",description = "Aucune catégorie n'existe dans la BDD avec l'Id fourni")
    })
    CategoryDto findById(@PathVariable("categoryId") Integer id);

    @DeleteMapping(path = APP_ROOT + "/categories/delete/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Supprimer une catégorie" , description = "Cette méthode permet de supprimer une catégorie par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La catégorie  a été supprimée")
    })
    void delete(@PathVariable("categoryId") Integer id);

    @GetMapping(path = APP_ROOT + "/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une catégorie par CODE" , description = "Cette méthode permet de chercher une catégorie par son CODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La catégorie a été trouve dans la BDD"),
            @ApiResponse(responseCode = "404",description = "Aucune catégorie n'existe dans la BDD avec le CODE fourni")
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String code);

}
