/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.model;

/**
 *
 * @author Dinuli Disara
 */
import model.Dentist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DentistTest {

    @Test
    public void testCreateDentist() {

        Dentist dentist = new Dentist(
                2,
                "Dr. Silva",
                "drsilva@gmail.com",
                "0771234567",
                "General Dentistry",
                3500.00,
                "ACTIVE"
        );

        assertEquals(2, dentist.getUserId());
        assertEquals("Dr. Silva", dentist.getName());
        assertEquals("drsilva@gmail.com", dentist.getEmail());
        assertEquals("0771234567", dentist.getContactNo());
        assertEquals("General Dentistry", dentist.getSpecialization());
        assertEquals(3500.00, dentist.getConsultationFee());
        assertEquals("ACTIVE", dentist.getStatus());
    }

    @Test
    public void testSetDentistId() {

        Dentist dentist = new Dentist();

        dentist.setDentistId(1);

        assertEquals(1, dentist.getDentistId());
    }

    @Test
    public void testSetName() {

        Dentist dentist = new Dentist();

        dentist.setName("Dr. Perera");

        assertEquals("Dr. Perera", dentist.getName());
    }

    @Test
    public void testSetSpecialization() {

        Dentist dentist = new Dentist();

        dentist.setSpecialization("Orthodontics");

        assertEquals("Orthodontics", dentist.getSpecialization());
    }

    @Test
    public void testSetConsultationFee() {

        Dentist dentist = new Dentist();

        dentist.setConsultationFee(5000.00);

        assertEquals(5000.00, dentist.getConsultationFee());
    }

    @Test
    public void testSetStatus() {

        Dentist dentist = new Dentist();

        dentist.setStatus("INACTIVE");

        assertEquals("INACTIVE", dentist.getStatus());
    }
}
