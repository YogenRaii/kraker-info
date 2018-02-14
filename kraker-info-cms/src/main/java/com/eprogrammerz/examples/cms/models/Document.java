package com.eprogrammerz.examples.cms.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class Document {
    private String id;

    private String docName;

    private MultipartFile file;
}
