package com.tracnghiem.demo.DTO.User;

import com.tracnghiem.demo.Entity.User;
import java.util.List;

public class UserExcel {

    private int status;
    private String message;
    private List<User> users;
    private int total;

    public UserExcel(int status, String message, List<User> users, int total) {
        this.status = status;
        this.message = message;
        this.users = users;
        this.total = total;
    }

    // Getters and Setters
}
