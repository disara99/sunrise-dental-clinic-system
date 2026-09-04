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
import java.sql.Time;
import model.Appointment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    void testAppointmentCreation() {

        Date appointmentDate = Date.valueOf("2026-09-10");
        Time appointmentTime = Time.valueOf("10:30:00");

        Appointment appointment = new Appointment(
                1,
                "APT001",
                2,
                1,
                3,
                appointmentDate,
                appointmentTime,
                "SCHEDULED",
                5
        );

        assertEquals(1, appointment.getAppointmentId());
        assertEquals("APT001", appointment.getAppointmentNo());
        assertEquals(2, appointment.getPatientId());
        assertEquals(1, appointment.getDentistId());
        assertEquals(3, appointment.getTreatmentId());
        assertEquals(appointmentDate, appointment.getAppointmentDate());
        assertEquals(appointmentTime, appointment.getAppointmentTime());
        assertEquals("SCHEDULED", appointment.getStatus());
        assertEquals(5, appointment.getCreatedBy());
    }

    @Test
    void testSetters() {

        Appointment appointment = new Appointment();

        Date appointmentDate = Date.valueOf("2026-09-15");
        Time appointmentTime = Time.valueOf("14:00:00");

        appointment.setAppointmentId(2);
        appointment.setAppointmentNo("APT002");
        appointment.setPatientId(4);
        appointment.setDentistId(2);
        appointment.setTreatmentId(5);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setStatus("COMPLETED");
        appointment.setCreatedBy(3);

        assertEquals(2, appointment.getAppointmentId());
        assertEquals("APT002", appointment.getAppointmentNo());
        assertEquals(4, appointment.getPatientId());
        assertEquals(2, appointment.getDentistId());
        assertEquals(5, appointment.getTreatmentId());
        assertEquals(appointmentDate, appointment.getAppointmentDate());
        assertEquals(appointmentTime, appointment.getAppointmentTime());
        assertEquals("COMPLETED", appointment.getStatus());
        assertEquals(3, appointment.getCreatedBy());
    }
}
