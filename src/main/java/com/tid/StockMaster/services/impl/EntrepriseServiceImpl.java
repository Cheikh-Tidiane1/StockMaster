package com.tid.StockMaster.services.impl;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import com.tid.StockMaster.dto.EntrepriseDto;
import com.tid.StockMaster.dto.RolesDto;
import com.tid.StockMaster.dto.UtilisateurDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidEntityException;
import com.tid.StockMaster.repository.EntrepriseRepository;
import com.tid.StockMaster.repository.RolesRepository;
import com.tid.StockMaster.services.EntrepriseService;
import com.tid.StockMaster.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

  private final UtilisateurServiceImpl utilisateurServiceImpl;
  private final RolesRepository rolesRepository;
  private EntrepriseRepository entrepriseRepository;

  @Autowired
  public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, UtilisateurServiceImpl utilisateurServiceImpl, RolesRepository rolesRepository) {
    this.entrepriseRepository = entrepriseRepository;
    this.utilisateurServiceImpl = utilisateurServiceImpl;
    this.rolesRepository = rolesRepository;
  }

  @Override
  public EntrepriseDto save(EntrepriseDto dto) {
    List<String> errors = EntrepriseValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Entreprise is not valid {}", dto);
      throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
    }
    EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
            entrepriseRepository.save(EntrepriseDto.toEntity(dto))
    );
    UtilisateurDto utilisateur = fromEntreprise(savedEntreprise);

    UtilisateurDto savedUser = utilisateurServiceImpl.save(utilisateur);

    RolesDto rolesDto = RolesDto.builder()
            .roleName("ADMIN")
            .utilisateur(savedUser)
            .build();

    rolesRepository.save(RolesDto.toEntity(rolesDto));

    return  savedEntreprise;
  }

  private UtilisateurDto fromEntreprise(EntrepriseDto dto) {
    return UtilisateurDto.builder()
            .adresse(dto.getAdresse())
            .nom(dto.getNom())
            .prenom(dto.getCodeFiscal())
            .email(dto.getEmail())
            .moteDePasse(generateRandomPassword())
            .entreprise(dto)
            .dateDeNaissance(Instant.now())
            .photo(dto.getPhoto())
            .build();
  }

  private String generateRandomPassword() {
    return "som3R@nd0mP@$$word";
  }
  @Override
  public EntrepriseDto findById(Integer id) {
    if (id == null) {
      log.error("Entreprise ID is null");
      return null;
    }
    return entrepriseRepository.findById(id)
        .map(EntrepriseDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune entreprise avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
  }

  @Override
  public Iterable<EntrepriseDto> findAll() {
    return entrepriseRepository.findAll().stream()
        .map(EntrepriseDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Entreprise ID is null");
      return;
    }
    entrepriseRepository.deleteById(id);
  }
}
