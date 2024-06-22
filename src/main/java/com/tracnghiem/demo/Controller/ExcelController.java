package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.DTO.User.UserExcel;
import com.tracnghiem.demo.Entity.User;
import com.tracnghiem.demo.Service.ExcelService;
import com.tracnghiem.demo.Service.FilesStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class ExcelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelController.class);

    private final FilesStorageService filesStorageService;
    private final ExcelService excelService;

    @Autowired
    public ExcelController(FilesStorageService filesStorageService, ExcelService excelService) {
        this.filesStorageService = filesStorageService;
        this.excelService = excelService;
    }

    @PostMapping("/file/import/users")
    public ResponseEntity<UserExcel> uploadUsersFromExcel(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            String filePath = "excel-import-user";
            // Save file to local storage
            filesStorageService.save(file, filePath);

            // Read users from Excel file
            List<User> userList = excelService.readUsersFromExcelFile(filePath + "/" + file.getOriginalFilename());

            // Save users to database
            excelService.saveUsersToDatabase(userList);

            message = "Successfully imported users from Excel file: " + file.getOriginalFilename();
            return ResponseEntity.ok().body(new UserExcel(HttpStatus.OK.value(), message, userList, userList.size()));
        } catch (Exception e) {
            message = "Failed to import users from Excel file: " + file.getOriginalFilename() + "!";
            LOGGER.error(e.getMessage());
            return ResponseEntity.badRequest().body(new UserExcel(HttpStatus.EXPECTATION_FAILED.value(), message, null, 0));
        } finally {
            // Optionally load the file (if needed)
            filesStorageService.load(file.getOriginalFilename());
        }
    }
}
