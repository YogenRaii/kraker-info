package com.eprogrammerz.examples.userSvc.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Yogen on 9/26/2017.
 */
@Getter
@Setter
public class Bookmark implements Serializable {
    private String userId;

    private Long id;

    private String href;

    private String description;

    private String label;
}