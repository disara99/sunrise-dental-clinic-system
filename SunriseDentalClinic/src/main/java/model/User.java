/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dinuli Disara
 */
package com.mycompany.sunrisedentalclinic.model;

import java.time.LocalDateTime;

public class User {

    private int userId;
    private String username;
    private String passwordHash;
    private String role;
    private String status;
    private LocalDateTime createdAt;

    // Default constructor
    public User() {
    }

    // Constructor without userId and createdAt
    public User(String username, String passwordHash,
                String role, String status) {

        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
    }

    // Full constructor
    public User(int userId, String username,
                String passwordHash, String role,
                String status, LocalDateTime createdAt) {

        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Get user ID
    public int getUserId() {
        return userId;
    }

    // Set user ID
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Get username
    public String getUsername() {
        return username;
    }

    // Set username
    public void setUsername(String username) {
        this.username = username;
    }

    // Get password hash
    public String getPasswordHash() {
        return passwordHash;
    }

    // Set password hash
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Get role
    public String getRole() {
        return role;
    }

    // Set role
    public void setRole(String role) {
        this.role = role;
    }

    // Get status
    public String getStatus() {
        return status;
    }

    // Set status
    public void setStatus(String status) {
        this.status = status;
    }

    // Get created date
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Set created date
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", username='" + username + '\''
                + ", role='" + role + '\''
                + ", status='" + status + '\''
                + ", createdAt=" + createdAt
                + '}';
    }
}
