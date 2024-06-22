package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Service.FilesStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    private final FilesStorageService filesStorageService;

    @Autowired
    public FileController(FilesStorageService filesStorageService) {
        this.filesStorageService = filesStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ServiceResult> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            filesStorageService.save(file, "uploads");
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.ok().body(new ServiceResult(HttpStatus.OK.value(), message, file.getContentType()));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            LOGGER.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ServiceResult(HttpStatus.EXPECTATION_FAILED.value(), message, null));
        }
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = filesStorageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
