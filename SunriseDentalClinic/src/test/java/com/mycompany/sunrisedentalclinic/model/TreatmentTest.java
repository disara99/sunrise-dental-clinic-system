/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.model;

/**
 *
 * @author Dinuli Disara
 */
import model.Treatment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreatmentTest {

    // =========================================================
    // TEST CONSTRUCTOR AND GETTERS
    // =========================================================
    @Test
    public void testCreateTreatment() {

        Treatment treatment = new Treatment(
                1,
                "Dental Check-up",
                "General dental examination",
                2000.00,
                "ACTIVE"
        );

        assertEquals(1, treatment.getTreatmentId());
        assertEquals("Dental Check-up", treatment.getTreatmentName());
        assertEquals(
                "General dental examination",
                treatment.getDescription()
        );
        assertEquals(2000.00, treatment.getTreatmentFee());
        assertEquals("ACTIVE", treatment.getStatus());
    }

    // =========================================================
    // TEST SETTERS
    // =========================================================
    @Test
    public void testSetters() {

        Treatment treatment = new Treatment();

        treatment.setTreatmentId(2);
        treatment.setTreatmentName("Dental Filling");
        treatment.setDescription("Treatment of a decayed tooth");
        treatment.setTreatmentFee(5000.00);
        treatment.setStatus("ACTIVE");

        assertEquals(2, treatment.getTreatmentId());
        assertEquals("Dental Filling", treatment.getTreatmentName());
        assertEquals(
                "Treatment of a decayed tooth",
                treatment.getDescription()
        );
        assertEquals(5000.00, treatment.getTreatmentFee());
        assertEquals("ACTIVE", treatment.getStatus());
    }
}
