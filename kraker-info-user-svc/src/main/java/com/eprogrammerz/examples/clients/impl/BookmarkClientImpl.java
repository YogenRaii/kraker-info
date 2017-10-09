package com.eprogrammerz.examples.clients.impl;

import com.eprogrammerz.examples.clients.BookmarkClient;
import com.eprogrammerz.examples.models.Bookmark;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yogen on 10/9/2017.
 */
@Component
public class BookmarkClientImpl implements BookmarkClient {
    @Override
    public List<Bookmark> getBookmarks(@PathVariable("userId") String userId) {
        return Arrays.asList(new Bookmark());
    }
}
