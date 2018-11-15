package com.eprogrammerz.examples.userSvc.services;

import com.eprogrammerz.examples.userSvc.clients.BookmarkClient;
import com.eprogrammerz.examples.userSvc.models.Bookmark;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Yogen on 10/11/2017.
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class BookmarkService {
    private final BookmarkClient bookmarkClient;

    private final CacheManager cacheManager;

    @CachePut(value = "bookmarks", key = "#p0")
    @HystrixCommand(fallbackMethod = "getBookmarksByUserIdFallback")
    public List<Bookmark> getBookmarksByUserId(String userId) {
        return this.bookmarkClient.getBookmarks(userId);
    }

    private List<Bookmark> getBookmarksByUserIdFallback(String userId) {
        try {
            if (this.cacheManager.getCache("bookmarks") != null && this.cacheManager.getCache("bookmarks").get(userId) != null) {
                return cacheManager.getCache("bookmarks").get(userId, List.class);
            }
        } catch (Exception ex) {
            log.error("Error connecting to Redis: {}", ex.getMessage());
        }

        return Collections.singletonList(new Bookmark());
    }
}
