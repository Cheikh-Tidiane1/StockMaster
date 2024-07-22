package com.tid.StockMaster.services.strategy;
import com.tid.StockMaster.model.Fournisseur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
@Slf4j
public class SaveFournisseurPhoto implements Strategy<Fournisseur> {
    @Override
    public Fournisseur savePhoto(Integer id, InputStream photo, String title) {
        return null;
    }
}
