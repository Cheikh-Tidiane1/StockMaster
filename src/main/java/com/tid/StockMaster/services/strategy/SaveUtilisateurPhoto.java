package com.tid.StockMaster.services.strategy;
import com.tid.StockMaster.model.Utilisateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
@Slf4j
public class SaveUtilisateurPhoto implements Strategy<Utilisateur> {
    @Override
    public Utilisateur savePhoto(Integer id, InputStream photo, String title) {
        return null;
    }
}
