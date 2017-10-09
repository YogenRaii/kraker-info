package com.eprogrammerz.examples.eureka.controllers;

import com.eprogrammerz.examples.eureka.models.Bookmark;
import com.eprogrammerz.examples.eureka.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Yogen on 9/26/2017.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class BookmarkController {

    private final BookmarkRepository bookmarkRepository;

    @GetMapping("/{userId}/bookmarks")
    Collection<Bookmark> getBookmarks(@PathVariable String userId) {
        return this.bookmarkRepository.findByUserId(userId);
    }

    @GetMapping("/{userId}/bookmarks/{bookmarkId}")
    Bookmark getBookmark(@PathVariable String userId,
                         @PathVariable Long bookmarkId) {
        return this.bookmarkRepository.findByUserIdAndId(userId, bookmarkId);
    }

    @PostMapping("/{userId}/bookmarks")
    Bookmark createBookmark(@PathVariable String userId,
                            @RequestBody Bookmark bookmark) {

        Bookmark bookmarkInstance = new Bookmark(
                userId,
                bookmark.getHref(),
                bookmark.getDescription(),
                bookmark.getLabel());

        return this.bookmarkRepository.save(bookmarkInstance);
    }
}
