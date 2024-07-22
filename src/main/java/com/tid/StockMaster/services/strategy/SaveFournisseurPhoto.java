package com.tid.StockMaster.services.strategy;

import com.tid.StockMaster.model.Fournisseur;

import java.io.InputStream;

public class SaveFournisseurPhoto implements Strategy<Fournisseur> {
    @Override
    public Fournisseur savePhoto(InputStream photo, String title) {
        return null;
    }
}
