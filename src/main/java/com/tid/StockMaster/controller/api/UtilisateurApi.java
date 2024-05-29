package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

  @PostMapping(path = APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  UtilisateurDto save(@RequestBody UtilisateurDto dto);

  @GetMapping(path = APP_ROOT + "/utilisateur/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
  UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

  @GetMapping(path = APP_ROOT + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
  Iterable<UtilisateurDto> findAll();

  @DeleteMapping(path = APP_ROOT + "/fournisseur/delete/{idUtilisateur}")
  void delete(@PathVariable("idUtilisateur") Integer id);

}
