package com.example.mhsolutions.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name ="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;

    private String phoneNumber;

    private boolean active;

    private String role;

    private Date regisDate;

    private String image;
    @Column(unique = true, nullable = false)
    private String email;

}
