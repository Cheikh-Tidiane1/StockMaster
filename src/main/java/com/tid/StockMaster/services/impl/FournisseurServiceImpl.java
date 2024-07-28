package com.tid.StockMaster.services.impl;
import java.util.List;
import java.util.stream.Collectors;
import com.tid.StockMaster.dto.FournisseurDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.exception.InvalidOperationException;
import com.tid.StockMaster.model.CommandeClient;
import com.tid.StockMaster.repository.CommandeFournisseurRepository;
import com.tid.StockMaster.repository.FournisseurRepository;
import com.tid.StockMaster.services.FournisseurService;
import com.tid.StockMaster.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

  private FournisseurRepository fournisseurRepository;
  private CommandeFournisseurRepository commandeFournisseurRepository;

  @Autowired
  public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, CommandeFournisseurRepository commandeFournisseurRepository) {
    this.fournisseurRepository = fournisseurRepository;
    this.commandeFournisseurRepository  = commandeFournisseurRepository;
  }

  @Override
  public FournisseurDto save(FournisseurDto dto) {
    List<String> errors = FournisseurValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Fournisseur is not valid {}", dto);
      throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
    }

    return FournisseurDto.fromEntity(
        fournisseurRepository.save(
            FournisseurDto.toEntity(dto)
        )
    );
  }

  @Override
  public FournisseurDto findById(Integer id) {
    if (id == null) {
      log.error("Fournisseur ID is null");
      return null;
    }
    return fournisseurRepository.findById(id)
        .map(FournisseurDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun fournisseur avec l'ID = " + id + " n'a été trouve dans la BDD",
            ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
  }

  @Override
  public List<FournisseurDto> findAll() {
    return fournisseurRepository.findAll().stream()
        .map(FournisseurDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Fournisseur ID is null");
      return;
    }
    List<CommandeClient> commandeFournisseur = commandeFournisseurRepository.findAllByFournisseurId(id);
    if (!commandeFournisseur.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un fournisseur qui a deja des commandes",
              ErrorCodes.FOURNISSEUR_ALREADY_IN_USE);
    }
    fournisseurRepository.deleteById(id);
  }
}
