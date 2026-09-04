/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.MedicalRecordDAO;
import model.MedicalRecord;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordDAOTest {

    private final MedicalRecordDAO medicalRecordDAO =
            new MedicalRecordDAO();

    @Test
    void testGetAllMedicalRecords() {

        List<MedicalRecord> records =
                medicalRecordDAO.getAllMedicalRecords();

        assertNotNull(records);
    }

    @Test
    void testFindById() {

        List<MedicalRecord> records =
                medicalRecordDAO.getAllMedicalRecords();

        if (records.isEmpty()) {
            return;
        }

        int recordId = records.get(0).getRecordId();

        MedicalRecord record =
                medicalRecordDAO.findById(recordId);

        assertNotNull(record);
        assertEquals(recordId, record.getRecordId());
    }

    @Test
    void testGetRecordsByPatientId() {

        List<MedicalRecord> records =
                medicalRecordDAO.getAllMedicalRecords();

        if (records.isEmpty()) {
            return;
        }

        int patientId =
                records.get(0).getPatientId();

        List<MedicalRecord> patientRecords =
                medicalRecordDAO.getRecordsByPatientId(patientId);

        assertNotNull(patientRecords);

        for (MedicalRecord record : patientRecords) {
            assertEquals(patientId, record.getPatientId());
        }
    }

    @Test
    void testGetRecordsByDentistId() {

        List<MedicalRecord> records =
                medicalRecordDAO.getAllMedicalRecords();

        if (records.isEmpty()) {
            return;
        }

        int dentistId =
                records.get(0).getDentistId();

        List<MedicalRecord> dentistRecords =
                medicalRecordDAO.getRecordsByDentistId(dentistId);

        assertNotNull(dentistRecords);

        for (MedicalRecord record : dentistRecords) {
            assertEquals(dentistId, record.getDentistId());
        }
    }

    @Test
    void testInsertMedicalRecord() {

        List<MedicalRecord> appointmentsRecords =
                medicalRecordDAO.getAllMedicalRecords();

        /*
         * This test requires valid patient, dentist and appointment IDs.
         * Change these three IDs to values that currently exist
         * in your database if necessary.
         */
        MedicalRecord record = new MedicalRecord(
                0,
                1,
                1,
                1,
                "JUnit Test Diagnosis",
                "JUnit test treatment notes",
                "JUnit test prescription",
                Date.valueOf("2026-09-03")
        );

        boolean result =
                medicalRecordDAO.insertMedicalRecord(record);

        assertTrue(result);
        assertTrue(record.getRecordId() > 0);
    }

    @Test
    void testUpdateMedicalRecord() {

        /*
         * First create a record.
         * Change patientId, dentistId and appointmentId
         * below if these IDs do not exist in your database.
         */
        MedicalRecord record = new MedicalRecord(
                0,
                1,
                1,
                1,
                "Original Diagnosis",
                "Original Notes",
                "Original Prescription",
                Date.valueOf("2026-09-03")
        );

        boolean inserted =
                medicalRecordDAO.insertMedicalRecord(record);

        assertTrue(inserted);
        assertTrue(record.getRecordId() > 0);

        record.setDiagnosis("Updated Diagnosis");
        record.setTreatmentNotes("Updated treatment notes");
        record.setPrescription("Updated prescription");
        record.setRecordDate(
                Date.valueOf("2026-09-04")
        );

        boolean updated =
                medicalRecordDAO.updateMedicalRecord(record);

        assertTrue(updated);

        MedicalRecord updatedRecord =
                medicalRecordDAO.findById(
                        record.getRecordId()
                );

        assertNotNull(updatedRecord);

        assertEquals(
                "Updated Diagnosis",
                updatedRecord.getDiagnosis()
        );

        assertEquals(
                "Updated treatment notes",
                updatedRecord.getTreatmentNotes()
        );

        assertEquals(
                "Updated prescription",
                updatedRecord.getPrescription()
        );
    }

    @Test
    void testDeleteMedicalRecord() {

        MedicalRecord record = new MedicalRecord(
                0,
                1,
                1,
                1,
                "Delete Test Diagnosis",
                "Delete Test Notes",
                "Delete Test Prescription",
                Date.valueOf("2026-09-05")
        );

        boolean inserted =
                medicalRecordDAO.insertMedicalRecord(record);

        assertTrue(inserted);

        int recordId = record.getRecordId();

        boolean deleted =
                medicalRecordDAO.deleteMedicalRecord(recordId);

        assertTrue(deleted);

        MedicalRecord deletedRecord =
                medicalRecordDAO.findById(recordId);

        assertNull(deletedRecord);
    }
}
