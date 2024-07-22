package com.tid.StockMaster.services.strategy;
import com.tid.StockMaster.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
@Slf4j
public class SaveClientPhoto implements Strategy<Client> {

    @Override
    public Client savePhoto(Integer id, InputStream photo, String title) {
        return null;
    }
}
