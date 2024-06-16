package com.tracnghiem.demo.Controller;


import com.tracnghiem.demo.DTO.Auth.LoginRequest;
import com.tracnghiem.demo.DTO.User.UserResponseDTO;
import com.tracnghiem.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequest loginRequest) {
        UserResponseDTO userResponseDTO = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }
}
