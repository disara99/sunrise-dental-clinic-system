/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.TreatmentDAO;
import java.util.List;
import model.Treatment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreatmentDAOTest {

    private TreatmentDAO treatmentDAO;

    @BeforeEach
    public void setUp() {
        treatmentDAO = new TreatmentDAO();
    }

    // =========================================================
    // TEST GET ALL TREATMENTS
    // =========================================================
    @Test
    public void testGetAllTreatments() {

        List<Treatment> treatments =
                treatmentDAO.getAllTreatments();

        assertNotNull(treatments);

        System.out.println(
                "Number of treatments: " + treatments.size()
        );
    }

    // =========================================================
    // TEST INSERT TREATMENT
    // =========================================================
    @Test
    public void testInsertTreatment() {

        Treatment treatment = new Treatment(
                "JUnit Test Treatment",
                "Treatment created for JUnit testing",
                2500.00,
                "ACTIVE"
        );

        boolean result =
                treatmentDAO.insertTreatment(treatment);

        assertTrue(result);

        assertTrue(
                treatment.getTreatmentId() > 0
        );
    }

    // =========================================================
    // TEST UPDATE TREATMENT
    // =========================================================
    @Test
    public void testUpdateTreatment() {

        Treatment treatment = new Treatment(
                1,
                "Updated Dental Check-up",
                "Updated treatment description",
                2200.00,
                "ACTIVE"
        );

        boolean result =
                treatmentDAO.updateTreatment(treatment);

        assertTrue(result);
    }

    // =========================================================
    // TEST DEACTIVATE TREATMENT
    // =========================================================
    @Test
    public void testDeactivateTreatment() {

        boolean result =
                treatmentDAO.deactivateTreatment(1);

        assertTrue(result);
    }
}
