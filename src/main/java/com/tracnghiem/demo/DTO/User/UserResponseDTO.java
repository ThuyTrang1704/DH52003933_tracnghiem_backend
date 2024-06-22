package com.tracnghiem.demo.DTO.User;

import lombok.Data;

@Data
public class UserResponseDTO {
    private char id;
    private String email;
    private String name;
    private String gender;
    private String address;
    private String phone;
    private Boolean status;
    private String roleName;
}