package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String gender;
    private String address;
    private String phone;
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity aClass;
}
