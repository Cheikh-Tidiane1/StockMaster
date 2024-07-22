package com.tid.StockMaster.services.strategy;
import com.tid.StockMaster.model.Entreprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
@Slf4j
public class SaveEntreprisePhoto implements Strategy<Entreprise> {

    @Override
    public Entreprise savePhoto(Integer id, InputStream photo, String title) {
        return null;
    }
}
