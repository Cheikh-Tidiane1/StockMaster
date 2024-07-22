package com.tid.StockMaster.services.strategy;

import com.tid.StockMaster.model.Utilisateur;

import java.io.InputStream;

public class SaveUtilisateurPhoto implements Strategy<Utilisateur> {
    @Override
    public Utilisateur savePhoto(InputStream photo, String title) {
        return null;
    }
}
