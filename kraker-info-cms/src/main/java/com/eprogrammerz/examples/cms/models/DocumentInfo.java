package com.eprogrammerz.examples.cms.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DocumentInfo {
    private String docName;

    private String s3key;

    private String url;
}
