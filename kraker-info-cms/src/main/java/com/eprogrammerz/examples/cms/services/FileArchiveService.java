package com.eprogrammerz.examples.cms.services;

import com.eprogrammerz.examples.cms.models.Document;
import com.eprogrammerz.examples.cms.models.DocumentInfo;

public interface FileArchiveService {
    DocumentInfo saveFile(Document document);
}
