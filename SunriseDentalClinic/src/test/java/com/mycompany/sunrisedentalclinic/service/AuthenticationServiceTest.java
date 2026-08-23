/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.service;

import com.mycompany.sunrisedentalclinic.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTest {

    AuthenticationService auth = new AuthenticationService();

    @Test
    public void testAdminLogin() {

        User user = auth.login("admin", "TEMP_PASSWORD");

        assertNotNull(user);
        assertEquals("ADMIN", user.getRole());
    }

    @Test
    public void testWrongPassword() {

        User user = auth.login("admin", "123456");

        assertNull(user);
    }

    @Test
    public void testDentistLogin() {

        User user = auth.login("dentist01", "TEMP_PASSWORD");

        assertNotNull(user);
        assertEquals("DENTIST", user.getRole());
    }

    @Test
    public void testReceptionLogin() {

        User user = auth.login("reception01", "TEMP_PASSWORD");

        assertNotNull(user);
        assertEquals("RECEPTIONIST", user.getRole());
    }
}
