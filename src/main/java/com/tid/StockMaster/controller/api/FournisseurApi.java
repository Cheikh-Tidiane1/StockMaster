package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;


public interface FournisseurApi {

  @PostMapping(path = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  FournisseurDto save(@RequestBody FournisseurDto dto);

  @GetMapping(path = APP_ROOT + "/fournisseur/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
  FournisseurDto findById(@PathVariable("idEntreprise") Integer id);

  @GetMapping(path = APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
  Iterable<FournisseurDto> findAll();

  @DeleteMapping(path = APP_ROOT + "/fournisseur/delete/{idEntreprise}")
  void delete(@PathVariable("idFournisseur") Integer id);

}
