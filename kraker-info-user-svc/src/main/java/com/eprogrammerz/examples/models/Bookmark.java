package com.eprogrammerz.examples.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Yogen on 9/26/2017.
 */
@Getter
@Setter
public class Bookmark {
    private String userId;

    private Long id;

    private String href;

    private String description;

    private String label;
}