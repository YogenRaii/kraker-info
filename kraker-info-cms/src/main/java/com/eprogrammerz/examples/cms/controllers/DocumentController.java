package com.eprogrammerz.examples.cms.controllers;

import com.eprogrammerz.examples.cms.models.Document;
import com.eprogrammerz.examples.cms.services.FileArchiveService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cms")
public class DocumentController {
    @Autowired
    private FileArchiveService fileArchiveService;

    @PostMapping(value = "/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadDocument(@RequestParam("file") MultipartFile file,
                                            @RequestParam("docName") String docName,
                                            @ApiParam(value = "Token with format 'Bearer Token'", required = true)
                                            @RequestHeader("Authorization") final String authorization) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Invalid file!");
        }

        Document document = new Document("id", docName, file);
        this.fileArchiveService.saveFile(document);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
