/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.ReceptionistDAO;
import java.util.List;
import model.Receptionist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReceptionistDAOTest {

    private ReceptionistDAO receptionistDAO;

    @BeforeEach
    public void setUp() {

        receptionistDAO = new ReceptionistDAO();
    }

    // =========================================================
    // TEST GET ALL RECEPTIONISTS
    // =========================================================
    @Test
    public void testGetAllReceptionists() {

        List<Receptionist> receptionists =
                receptionistDAO.getAllReceptionists();

        assertNotNull(receptionists);
    }

    // =========================================================
    // TEST INSERT RECEPTIONIST
    // =========================================================
    @Test
    public void testInsertReceptionist() {

        Receptionist receptionist = new Receptionist(
                1,
                "JUnit Receptionist",
                "junit.receptionist@example.com",
                "0771234567",
                "ACTIVE"
        );

        boolean result =
                receptionistDAO.insertReceptionist(receptionist);

        assertTrue(result);
    }
    // =========================================================
// =========================================================
// TEST UPDATE RECEPTIONIST
// =========================================================
@Test
public void testUpdateReceptionist() {

    Receptionist receptionist = new Receptionist(
            1,  // receptionistId
            3,  // userId
            "Updated Receptionist",
            "updated.receptionist@example.com",
            "0779999999",
            "ACTIVE"
    );

    boolean result =
            receptionistDAO.updateReceptionist(receptionist);

    assertTrue(result);
}
}