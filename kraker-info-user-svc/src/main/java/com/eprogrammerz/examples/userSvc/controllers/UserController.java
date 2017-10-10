package com.eprogrammerz.examples.userSvc.controllers;

import com.eprogrammerz.examples.userSvc.clients.BookmarkClient;
import com.eprogrammerz.examples.userSvc.models.Bookmark;
import com.eprogrammerz.examples.userSvc.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yogen on 9/26/2017.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserController {
    private final BookmarkClient bookmarkClient;

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserInfo(@PathVariable("userId") String userId) {
        List<Bookmark> bookmarks = this.bookmarkClient.getBookmarks(userId);
        User user = new User(userId, bookmarks);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
