package com.tid.StockMaster.services.strategy;

import com.tid.StockMaster.model.Article;

import java.io.InputStream;

public class SaveArticlePhoto implements Strategy<Article> {

    @Override
    public Article savePhoto(InputStream photo, String title) {
        return null;
    }
}
