package com.tracnghiem.demo.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceResult {

    private int status;
    private String message;
    private String contentType;

    // Getters and Setters
}
