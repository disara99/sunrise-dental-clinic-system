/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.model;

/**
 *
 * @author Dinuli Disara
 */
import java.sql.Date;
import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    void testPatientCreation() {

        Date dob = Date.valueOf("2000-05-15");

        Patient patient = new Patient(
                1,
                "Test Patient",
                "Colombo",
                "0771234567",
                dob,
                "FEMALE"
        );

        assertEquals(1, patient.getPatientId());
        assertEquals("Test Patient", patient.getName());
        assertEquals("Colombo", patient.getAddress());
        assertEquals("0771234567", patient.getContactNo());
        assertEquals(dob, patient.getDateOfBirth());
        assertEquals("FEMALE", patient.getGender());
    }

    @Test
    void testSetters() {

        Patient patient = new Patient();

        Date dob = Date.valueOf("1998-10-20");

        patient.setPatientId(2);
        patient.setName("Updated Patient");
        patient.setAddress("Kandy");
        patient.setContactNo("0719876543");
        patient.setDateOfBirth(dob);
        patient.setGender("MALE");

        assertEquals(2, patient.getPatientId());
        assertEquals("Updated Patient", patient.getName());
        assertEquals("Kandy", patient.getAddress());
        assertEquals("0719876543", patient.getContactNo());
        assertEquals(dob, patient.getDateOfBirth());
        assertEquals("MALE", patient.getGender());
    }
}
