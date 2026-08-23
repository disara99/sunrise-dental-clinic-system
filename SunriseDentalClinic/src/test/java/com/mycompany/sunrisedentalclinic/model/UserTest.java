/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testCreateUser() {

        User user = new User(
                "admin",
                "hashedPassword",
                "ADMIN",
                "ACTIVE"
        );

        assertEquals("admin", user.getUsername());
        assertEquals("hashedPassword", user.getPasswordHash());
        assertEquals("ADMIN", user.getRole());
        assertEquals("ACTIVE", user.getStatus());
    }

    @Test
    public void testSetUserId() {

        User user = new User();

        user.setUserId(1);

        assertEquals(1, user.getUserId());
    }

    @Test
    public void testSetUsername() {

        User user = new User();

        user.setUsername("dentist01");

        assertEquals("dentist01", user.getUsername());
    }

    @Test
    public void testSetRole() {

        User user = new User();

        user.setRole("DENTIST");

        assertEquals("DENTIST", user.getRole());
    }

    @Test
    public void testSetStatus() {

        User user = new User();

        user.setStatus("INACTIVE");

        assertEquals("INACTIVE", user.getStatus());
    }
}