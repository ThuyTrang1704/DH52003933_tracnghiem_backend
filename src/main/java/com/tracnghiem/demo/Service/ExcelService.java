package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.User;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    List<User> readUsersFromExcelFile(String filePath) throws IOException;
    void saveUsersToDatabase(List<User> users);
}
