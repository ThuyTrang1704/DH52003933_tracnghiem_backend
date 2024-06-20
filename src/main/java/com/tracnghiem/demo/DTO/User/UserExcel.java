package com.tracnghiem.demo.DTO.User;

import com.tracnghiem.demo.Entity.User;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
@Entity

public class UserExcel {
    private int status;
    private String message;
    private List<User> userList;
    private int totalUsers;

    public UserExcel(int status, String message, List<User> userList, int totalUsers) {
        this.status = status;
        this.message = message;
        this.userList = userList;
        this.totalUsers = totalUsers;
    }

    // Getters and setters

}

