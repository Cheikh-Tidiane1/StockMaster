package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.ArticleDto;
import com.tid.StockMaster.dto.LigneCommandeClientDto;
import com.tid.StockMaster.dto.LigneCommandeFournisseurDto;
import com.tid.StockMaster.dto.LigneVenteDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;


public interface ArticleApi {

    @PostMapping(path = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enregistre un article" , description = "Cette méthode permet d'enregistrer ou modifier un article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "L'objet article cree / modifie"),
            @ApiResponse(responseCode = "400",description = "L'objet article n'est pas valide")
    })
    ResponseEntity<ArticleDto> save (@RequestBody ArticleDto articleDto);
    @GetMapping(path = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un article par ID" , description = "Cette méthode permet de chercher un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "L'article a été trouve dans la BDD"),
            @ApiResponse(responseCode = "404",description = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ResponseEntity<ArticleDto> findById(@PathVariable("idArticle") Integer id);
    @GetMapping(path = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un article par CODE" , description = "Cette méthode permet de chercher un article par son CODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "L'article a été trouve dans la BDD"),
            @ApiResponse(responseCode = "404",description = "Aucun article n'existe dans la BDD avec le Code fourni")
    })
    ResponseEntity<ArticleDto> findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
    @GetMapping(path = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des articles" , description = "Cette méthode permet de chercher et renvoyer la liste des articles qui existent dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La liste des articles / Une liste vide")
    })
    ResponseEntity<Iterable<ArticleDto>> findAll();
    @DeleteMapping(path = APP_ROOT + "/articles/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Supprimer un article" , description = "Cette méthode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "L'article  a été supprimé")
    })
    ResponseEntity deleteById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandeclient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeClientDto> findHistoriqueCommandeClient(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);
}
