package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface EntrepriseApi {

  @PostMapping(path = APP_ROOT + "/entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  EntrepriseDto save(@RequestBody EntrepriseDto dto);

  @GetMapping(path = APP_ROOT + "/entreprise/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
  EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

  @GetMapping(path = APP_ROOT + "/entreprise/all", produces = MediaType.APPLICATION_JSON_VALUE)
  Iterable<EntrepriseDto> findAll();

  @DeleteMapping(path = APP_ROOT + "/entreprise/delete/{idEntreprise}")
  void delete(@PathVariable("idEntreprise") Integer id);

}
