package com.eprogrammerz.examples.userSvc.clients.impl;

import com.eprogrammerz.examples.userSvc.clients.BookmarkClient;
import com.eprogrammerz.examples.userSvc.models.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yogen on 10/9/2017.
 */
@Component
public class BookmarkClientImpl implements BookmarkClient {
    @Autowired
    private CacheManager cacheManager;

    @Override
    public List<Bookmark> getBookmarks(@PathVariable("userId") String userId) {
        if (this.cacheManager.getCache("bookmarks") != null && this.cacheManager.getCache("bookmarks").get(userId) != null) {
            return cacheManager.getCache("bookmarks").get(userId, List.class);
        }
        return Arrays.asList(new Bookmark());
    }
}
