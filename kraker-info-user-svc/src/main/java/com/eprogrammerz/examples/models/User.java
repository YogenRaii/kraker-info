package com.eprogrammerz.examples.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Yogen on 9/26/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String id;

    private List<Bookmark> bookmarks;
}
