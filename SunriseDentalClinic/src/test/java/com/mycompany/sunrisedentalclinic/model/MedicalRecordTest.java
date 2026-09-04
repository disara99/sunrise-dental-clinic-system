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
import model.MedicalRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordTest {

    @Test
    void testMedicalRecordCreation() {

        Date recordDate = Date.valueOf("2026-09-03");

        MedicalRecord record = new MedicalRecord(
                1,
                2,
                1,
                5,
                "Dental Caries",
                "Dental filling recommended.",
                "Paracetamol if required.",
                recordDate
        );

        assertEquals(1, record.getRecordId());
        assertEquals(2, record.getPatientId());
        assertEquals(1, record.getDentistId());
        assertEquals(5, record.getAppointmentId());
        assertEquals("Dental Caries", record.getDiagnosis());
        assertEquals(
                "Dental filling recommended.",
                record.getTreatmentNotes()
        );
        assertEquals(
                "Paracetamol if required.",
                record.getPrescription()
        );
        assertEquals(recordDate, record.getRecordDate());
    }

    @Test
    void testSetters() {

        MedicalRecord record = new MedicalRecord();

        Date recordDate = Date.valueOf("2026-09-04");

        record.setRecordId(2);
        record.setPatientId(3);
        record.setDentistId(2);
        record.setAppointmentId(6);
        record.setDiagnosis("Tooth Extraction");
        record.setTreatmentNotes("Extraction completed successfully.");
        record.setPrescription("Pain relief medication.");
        record.setRecordDate(recordDate);

        assertEquals(2, record.getRecordId());
        assertEquals(3, record.getPatientId());
        assertEquals(2, record.getDentistId());
        assertEquals(6, record.getAppointmentId());
        assertEquals("Tooth Extraction", record.getDiagnosis());
        assertEquals(
                "Extraction completed successfully.",
                record.getTreatmentNotes()
        );
        assertEquals(
                "Pain relief medication.",
                record.getPrescription()
        );
        assertEquals(recordDate, record.getRecordDate());
    }
}
