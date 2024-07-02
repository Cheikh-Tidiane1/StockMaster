package com.tid.StockMaster.services.auth;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.model.Utilisateur;
import com.tid.StockMaster.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    public ApplicationUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("L'utilisateur n'existe pas", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
        return new User(utilisateur.getEmail(),utilisateur.getMoteDePasse(), Collections.emptyList());
    }
}
