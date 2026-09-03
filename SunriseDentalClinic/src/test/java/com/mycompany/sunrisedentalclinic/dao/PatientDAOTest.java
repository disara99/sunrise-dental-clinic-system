/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.PatientDAO;
import model.Patient;
import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientDAOTest {

    private final PatientDAO patientDAO = new PatientDAO();

    @Test
    void testGetAllPatients() {

        List<Patient> patients = patientDAO.getAllPatients();

        assertNotNull(patients);
    }

    @Test
    void testInsertPatient() {

        Patient patient = new Patient(
                0,
                "JUnit Test Patient",
                "Colombo",
                "0771112222",
                Date.valueOf("2000-01-15"),
                "FEMALE"
        );

        boolean result = patientDAO.insertPatient(patient);

        assertTrue(result);
        assertTrue(patient.getPatientId() > 0);
    }

    @Test
    void testFindById() {

        Patient patient = new Patient(
                0,
                "Find Test Patient",
                "Kandy",
                "0712223333",
                Date.valueOf("1995-06-10"),
                "MALE"
        );

        boolean inserted = patientDAO.insertPatient(patient);

        assertTrue(inserted);

        Patient foundPatient =
                patientDAO.findById(patient.getPatientId());

        assertNotNull(foundPatient);
        assertEquals("Find Test Patient", foundPatient.getName());
    }

    @Test
    void testUpdatePatient() {

        Patient patient = new Patient(
                0,
                "Update Test Patient",
                "Galle",
                "0754445555",
                Date.valueOf("1990-03-20"),
                "OTHER"
        );

        boolean inserted = patientDAO.insertPatient(patient);

        assertTrue(inserted);

        patient.setName("Updated Patient");
        patient.setAddress("Matara");
        patient.setContactNo("0769998888");

        boolean updated = patientDAO.updatePatient(patient);

        assertTrue(updated);

        Patient updatedPatient =
                patientDAO.findById(patient.getPatientId());

        assertNotNull(updatedPatient);
        assertEquals("Updated Patient", updatedPatient.getName());
        assertEquals("Matara", updatedPatient.getAddress());
    }

    @Test
    void testDeletePatient() {

        Patient patient = new Patient(
                0,
                "Delete Test Patient",
                "Negombo",
                "0786667777",
                Date.valueOf("1988-12-05"),
                "MALE"
        );

        boolean inserted = patientDAO.insertPatient(patient);

        assertTrue(inserted);

        int patientId = patient.getPatientId();

        boolean deleted = patientDAO.deletePatient(patientId);

        assertTrue(deleted);

        Patient deletedPatient =
                patientDAO.findById(patientId);

        assertNull(deletedPatient);
    }
}