/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.DentistDAO;
import model.Dentist;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dinuli Disara
 */
public class DentistDAOTest {

    private final DentistDAO dentistDAO = new DentistDAO();

    // =========================================================
    // TEST 1 - GET ALL DENTISTS
    // =========================================================
    @Test
    public void testGetAllDentists() {

        List<Dentist> dentists = dentistDAO.getAllDentists();

        assertNotNull(dentists);
    }

    // =========================================================
    // TEST 2 - FIND DENTIST BY ID
    // =========================================================
    @Test
    public void testFindById() {

        List<Dentist> dentists = dentistDAO.getAllDentists();

        if (!dentists.isEmpty()) {

            int dentistId =
                    dentists.get(0).getDentistId();

            Dentist dentist =
                    dentistDAO.findById(dentistId);

            assertNotNull(dentist);

            assertEquals(
                    dentistId,
                    dentist.getDentistId()
            );
        }
    }

    // =========================================================
    // TEST 3 - FIND DENTIST BY USER ID
    // =========================================================
    @Test
    public void testFindByUserId() {

        List<Dentist> dentists = dentistDAO.getAllDentists();

        if (!dentists.isEmpty()) {

            int userId =
                    dentists.get(0).getUserId();

            Dentist dentist =
                    dentistDAO.findByUserId(userId);

            assertNotNull(dentist);

            assertEquals(
                    userId,
                    dentist.getUserId()
            );
        }
    }

    // =========================================================
    // TEST 4 - GET ACTIVE DENTISTS
    // =========================================================
    @Test
    public void testGetActiveDentists() {

        List<Dentist> dentists =
                dentistDAO.getActiveDentists();

        assertNotNull(dentists);

        for (Dentist dentist : dentists) {

            assertEquals(
                    "ACTIVE",
                    dentist.getStatus()
            );
        }
    }
}
