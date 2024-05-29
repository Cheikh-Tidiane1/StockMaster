package com.tid.StockMaster.services.impl;
import java.util.List;
import java.util.stream.Collectors;
import com.tid.StockMaster.dto.UtilisateurDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.repository.UtilisateurRepository;
import com.tid.StockMaster.services.UtilisateurService;
import com.tid.StockMaster.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

  private UtilisateurRepository utilisateurRepository;

  @Autowired
  public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
    this.utilisateurRepository = utilisateurRepository;
  }

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    List<String> errors = UtilisateurValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Utilisateur is not valid {}", dto);
      throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return UtilisateurDto.fromEntity(
        utilisateurRepository.save(
            UtilisateurDto.toEntity(dto)
        )
    );
  }

  @Override
  public UtilisateurDto findById(Integer id) {
    if (id == null) {
      log.error("Utilisateur ID is null");
      return null;
    }
    return utilisateurRepository.findById(id)
        .map(UtilisateurDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun utilisateur avec l'ID = " + id + " n'a  ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<UtilisateurDto> findAll() {
    return utilisateurRepository.findAll().stream()
        .map(UtilisateurDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Utilisateur ID is null");
      return;
    }
    utilisateurRepository.deleteById(id);
  }

}
