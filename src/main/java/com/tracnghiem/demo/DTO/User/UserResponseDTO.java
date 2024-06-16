package com.tracnghiem.demo.DTO.User;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    private String name;
    private String gender;
    private String address;
    private String phone;
    private String status;
    private String roleName;
}