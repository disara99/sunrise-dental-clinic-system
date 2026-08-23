/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

import com.mycompany.sunrisedentalclinic.model.User;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    private final UserDAO userDAO = new UserDAO();

    @Test
    public void testFindByUsername() {

        User user = userDAO.findByUsername("admin");

        assertNotNull(user);

        assertEquals("admin", user.getUsername());
        assertEquals("ADMIN", user.getRole());
        assertEquals("ACTIVE", user.getStatus());
    }

    @Test
    public void testFindByUsernameNotFound() {

        User user =
                userDAO.findByUsername("user_that_does_not_exist");

        assertNull(user);
    }

    @Test
    public void testGetAllUsers() {

        List<User> users = userDAO.getAllUsers();

        assertNotNull(users);
        assertTrue(users.size() >= 3);
    }

    @Test
    public void testAdminExists() {

        User admin = userDAO.findByUsername("admin");

        assertNotNull(admin);

        assertEquals("ADMIN", admin.getRole());
    }
}