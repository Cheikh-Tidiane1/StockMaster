package com.tid.StockMaster.services.strategy;

import java.io.InputStream;

public interface Strategy<T> {
    T savePhoto(InputStream photo, String title);
}
