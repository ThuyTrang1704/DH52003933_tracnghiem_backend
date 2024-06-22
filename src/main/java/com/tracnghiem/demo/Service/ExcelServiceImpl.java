package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.User;
import com.tracnghiem.demo.Repository.UserRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    private final UserRepository userRepository;

    @Autowired
    public ExcelServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> readUsersFromExcelFile(String filePath) throws IOException {
        List<User> userList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                User user = new User();
                user.setId((long) row.getCell(0).getNumericCellValue());
                user.setName(row.getCell(1).getStringCellValue());
                user.setEmail(row.getCell(2).getStringCellValue());
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public void saveUsersToDatabase(List<User> users) {
        userRepository.saveAll(users);
    }
}
