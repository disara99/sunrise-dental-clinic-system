/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.service;

import com.mycompany.sunrisedentalclinic.dao.UserDAO;
import com.mycompany.sunrisedentalclinic.model.User;

public class AuthenticationService {

    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {

        User user = userDAO.findByUsername(username);

        // User not found
        if (user == null) {
            return null;
        }

        // Account inactive
        if (!user.getStatus().equals("ACTIVE")) {
            return null;
        }

        // Temporary password check
        if (user.getPasswordHash().equals(password)) {
            return user;
        }

        return null;
    }
}
