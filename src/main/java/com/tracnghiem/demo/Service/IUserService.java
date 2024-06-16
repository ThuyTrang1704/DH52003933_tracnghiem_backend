package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.DTO.User.UserResponseDTO;
import com.tracnghiem.demo.Entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User userDetails);

    void deleteUser(Long id);

    UserResponseDTO login(String email, String password);
}
