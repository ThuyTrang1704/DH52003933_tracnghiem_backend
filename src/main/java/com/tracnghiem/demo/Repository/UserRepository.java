package com.tracnghiem.demo.Repository;

import com.tracnghiem.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
    