package com.tid.StockMaster.controller;
import com.tid.StockMaster.controller.api.CommandeClientApi;
import com.tid.StockMaster.dto.CommandeClientDto;
import com.tid.StockMaster.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeClientController implements CommandeClientApi {

    private CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto dto) {
        return ResponseEntity.ok(commandeClientService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer idCommandeClient) {
        return  ResponseEntity.ok(commandeClientService.findById(idCommandeClient));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<Iterable<CommandeClientDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        commandeClientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
