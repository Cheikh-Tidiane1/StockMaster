package com.tid.StockMaster.controller.api;

import com.flickr4java.flickr.FlickrException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface PhotoApi {
    @PostMapping(APP_ROOT + "/save/{id}/{title}/{context}")
    Object savePhoto(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile photo, @PathVariable(
            "title") String title) throws IOException,
            FlickrException;
}
