package com.tid.StockMaster.controller.api;
import java.util.List;
import com.tid.StockMaster.dto.CommandeClientDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface CommandeClientApi {

  @PostMapping(APP_ROOT + "/commandesclients/create")
  CommandeClientDto save(@RequestBody CommandeClientDto dto);

  @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
  CommandeClientDto findById(@PathVariable Integer idCommandeClient);

  @GetMapping(APP_ROOT + "/commandesclients/filter/{codeCommandeClient}")
  CommandeClientDto findByCode(@PathVariable("codeCommandeClient") String code);

  @GetMapping(APP_ROOT + "/commandesclients/all")
  Iterable<CommandeClientDto> findAll();

  @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
  void delete(@PathVariable("idCommandeClient") Integer id);

}
