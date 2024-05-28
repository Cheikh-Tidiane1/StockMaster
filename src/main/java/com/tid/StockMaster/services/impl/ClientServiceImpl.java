package com.tid.StockMaster.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import com.tid.StockMaster.dto.ClientDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.repository.ClientRepository;
import com.tid.StockMaster.services.ClientService;
import com.tid.StockMaster.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

  private ClientRepository  clientRepository;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public ClientDto save(ClientDto dto) {
    List<String> errors = ClientValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Client is not valid {}", dto);
      throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
    }

    return ClientDto.fromEntity(
        clientRepository.save(
            ClientDto.toEntity(dto)
        )
    );
  }

  @Override
  public ClientDto findById(Integer id) {
    if (id == null) {
      log.error("Client ID is null");
      return null;
    }
    return clientRepository.findById(id)
        .map(ClientDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun Client avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.CLIENT_NOT_FOUND)
        );
  }

  @Override
  public Iterable<ClientDto> findAll() {
    return clientRepository.findAll().stream()
        .map(ClientDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Client ID is null");
      return;
    }
    clientRepository.deleteById(id);
  }
}
