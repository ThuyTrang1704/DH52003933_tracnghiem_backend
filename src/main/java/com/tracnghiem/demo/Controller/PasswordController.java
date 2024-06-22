package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.User;
import com.tracnghiem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PasswordController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/change-password")
    public ResponseEntity<Map<String, String>> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        String email = request.getEmail();
        String currentPassword = request.getCurrentPassword();
        String newPassword = request.getNewPassword();

        // Tìm kiếm người dùng dựa trên email và password
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, currentPassword);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse("Invalid email or current password."));
        }

        // Lấy người dùng từ Optional
        User user = userOptional.get();

        // Cập nhật mật khẩu mới cho người dùng
        user.setPassword(newPassword);
        userRepository.save(user);

        // Trả về thông báo thành công
        Map<String, String> response = new HashMap<>();
        response.put("message", "Password changed successfully!");
        return ResponseEntity.ok(response);
    }

    public static class ChangePasswordRequest {
        private String email;
        private String currentPassword;
        private String newPassword;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCurrentPassword() {
            return currentPassword;
        }

        public void setCurrentPassword(String currentPassword) {
            this.currentPassword = currentPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }

    private Map<String, String> errorResponse(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("error", message);
        return response;
    }
}
