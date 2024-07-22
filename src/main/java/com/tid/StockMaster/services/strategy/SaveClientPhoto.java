package com.tid.StockMaster.services.strategy;

import com.tid.StockMaster.model.Client;

import java.io.InputStream;

public class SaveClientPhoto implements Strategy<Client> {

    @Override
    public Client savePhoto(InputStream photo, String title) {
        return null;
    }
}
