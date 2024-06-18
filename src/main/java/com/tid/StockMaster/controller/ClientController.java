package com.tid.StockMaster.controller;
import com.tid.StockMaster.controller.api.ClientApi;
import com.tid.StockMaster.dto.ClientDto;
import com.tid.StockMaster.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

  private ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @Override
  public ResponseEntity<ClientDto> save(ClientDto dto) {
    return ResponseEntity.ok(clientService.save(dto));
  }

  @Override
  public ResponseEntity<ClientDto> findById(Integer id) {
    return ResponseEntity.ok(clientService.findById(id));
  }

  @Override
  public ResponseEntity<Iterable<ClientDto>> findAll() {
    return ResponseEntity.ok(clientService.findAll());
  }

  @Override
  public ResponseEntity delete(Integer id) {
    clientService.delete(id);
    return ResponseEntity.ok().build();
  }
}
