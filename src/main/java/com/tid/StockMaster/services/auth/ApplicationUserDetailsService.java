package com.tid.StockMaster.services.auth;
import com.tid.StockMaster.dto.UtilisateurDto;
import com.tid.StockMaster.exception.EntityNotFoundException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.model.Utilisateur;
import com.tid.StockMaster.repository.UtilisateurRepository;
import com.tid.StockMaster.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private UtilisateurService utilisateurService;
    @Autowired
    public ApplicationUserDetailsService(UtilisateurService utilisateurService) {
       this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = utilisateurService.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new User(utilisateur.getEmail(),utilisateur.getMoteDePasse(), Collections.emptyList());
    }
}
