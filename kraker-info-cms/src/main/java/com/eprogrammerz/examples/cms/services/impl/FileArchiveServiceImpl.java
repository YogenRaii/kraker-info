package com.eprogrammerz.examples.cms.services.impl;

import com.eprogrammerz.examples.cms.exceptions.StorageException;
import com.eprogrammerz.examples.cms.models.Document;
import com.eprogrammerz.examples.cms.models.DocumentInfo;
import com.eprogrammerz.examples.cms.models.StorageProperties;
import com.eprogrammerz.examples.cms.services.FileArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileArchiveServiceImpl implements FileArchiveService {

    private final Path rootLocation;

    @Autowired
    public FileArchiveServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public DocumentInfo saveFile(Document document) {
        String filename = StringUtils.cleanPath(document.getFile().getOriginalFilename());
        Path filePath = null;
        try {
            if (document.getFile().isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            filePath = this.rootLocation.resolve(filename);
            Files.copy(document.getFile().getInputStream(), filePath,
                    StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
        return new DocumentInfo(document.getDocName(), document.getId(), filePath.toString());
    }

    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
