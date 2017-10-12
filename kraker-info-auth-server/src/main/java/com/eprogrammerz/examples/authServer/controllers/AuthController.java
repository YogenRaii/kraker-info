package com.eprogrammerz.examples.authServer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Yogen on 10/12/2017.
 */
@RestController
public class AuthController {
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
