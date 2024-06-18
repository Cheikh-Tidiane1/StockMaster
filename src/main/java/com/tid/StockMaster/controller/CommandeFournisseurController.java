package com.tid.StockMaster.controller;
import com.tid.StockMaster.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import com.tid.StockMaster.controller.api.CommandeFournisseurApi;
import com.tid.StockMaster.dto.CommandeFournisseurDto;
import com.tid.StockMaster.services.CommandeClientService;
import org.springframework.web.bind.annotation.RestController;

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
}
