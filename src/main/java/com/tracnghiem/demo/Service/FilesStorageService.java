package com.tracnghiem.demo.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FilesStorageService {
    void save(MultipartFile file, String path) throws IOException;
    Resource load(String filename);
}