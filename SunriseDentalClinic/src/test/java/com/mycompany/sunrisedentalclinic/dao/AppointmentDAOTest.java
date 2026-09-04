/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.AppointmentDAO;
import model.Appointment;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentDAOTest {

    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    @Test
    void testGetAllAppointments() {

        var appointments = appointmentDAO.getAllAppointments();

        assertNotNull(appointments);
    }

    @Test
    void testInsertAppointment() {

        Appointment appointment = new Appointment(
                0,
                "APT-JUNIT-001",
                1,
                1,
                1,
                Date.valueOf("2026-09-20"),
                Time.valueOf("10:30:00"),
                "SCHEDULED",
                3
        );

        boolean result = appointmentDAO.insertAppointment(appointment);

        assertTrue(result);
        assertTrue(appointment.getAppointmentId() > 0);
    }

    @Test
    void testFindById() {

        Appointment appointment = new Appointment(
                0,
                "APT-JUNIT-002",
                1,
                1,
                1,
                Date.valueOf("2026-09-21"),
                Time.valueOf("11:00:00"),
                "SCHEDULED",
                3
        );

        boolean inserted = appointmentDAO.insertAppointment(appointment);

        assertTrue(inserted);

        Appointment found =
                appointmentDAO.findById(appointment.getAppointmentId());

        assertNotNull(found);
        assertEquals(
                "APT-JUNIT-002",
                found.getAppointmentNo()
        );
    }

    @Test
void testUpdateAppointment() {

    Appointment appointment = new Appointment(
            0,
            "APT-UPDATE-" + System.currentTimeMillis(),
            1,
            1,
            1,
            Date.valueOf("2026-09-22"),
            Time.valueOf("12:00:00"),
            "SCHEDULED",
            3
    );

    // Insert first
    boolean inserted = appointmentDAO.insertAppointment(appointment);

    assertTrue(inserted);
    assertTrue(appointment.getAppointmentId() > 0);

    // Change values
    appointment.setAppointmentNo(
            "APT-UPDATED-" + System.currentTimeMillis()
    );

    appointment.setAppointmentDate(
            Date.valueOf("2026-09-25")
    );

    appointment.setAppointmentTime(
            Time.valueOf("15:30:00")
    );

    appointment.setStatus("COMPLETED");

    // Update
    boolean updated =
            appointmentDAO.updateAppointment(appointment);

    assertTrue(updated);

    // Read again from database
    Appointment updatedAppointment =
            appointmentDAO.findById(
                    appointment.getAppointmentId()
            );

    assertNotNull(updatedAppointment);

    assertEquals(
            appointment.getAppointmentNo(),
            updatedAppointment.getAppointmentNo()
    );

    assertEquals(
            Date.valueOf("2026-09-25"),
            updatedAppointment.getAppointmentDate()
    );

    assertEquals(
            Time.valueOf("15:30:00"),
            updatedAppointment.getAppointmentTime()
    );

    assertEquals(
            "COMPLETED",
            updatedAppointment.getStatus()
    );
}

    @Test
    void testUpdateStatus() {

        Appointment appointment = new Appointment(
                0,
                "APT-JUNIT-004",
                1,
                1,
                1,
                Date.valueOf("2026-09-23"),
                Time.valueOf("13:00:00"),
                "SCHEDULED",
                3
        );

        boolean inserted = appointmentDAO.insertAppointment(appointment);

        assertTrue(inserted);

        boolean updated =
                appointmentDAO.updateStatus(
                        appointment.getAppointmentId(),
                        "CANCELLED"
                );

        assertTrue(updated);

        Appointment updatedAppointment =
                appointmentDAO.findById(
                        appointment.getAppointmentId()
                );

        assertNotNull(updatedAppointment);
        assertEquals(
                "CANCELLED",
                updatedAppointment.getStatus()
        );
    }

    @Test
    void testDeleteAppointment() {

        Appointment appointment = new Appointment(
                0,
                "APT-JUNIT-005",
                1,
                1,
                1,
                Date.valueOf("2026-09-24"),
                Time.valueOf("14:00:00"),
                "SCHEDULED",
                3
        );

        boolean inserted = appointmentDAO.insertAppointment(appointment);

        assertTrue(inserted);

        int appointmentId = appointment.getAppointmentId();

        boolean deleted =
                appointmentDAO.deleteAppointment(appointmentId);

        assertTrue(deleted);

        Appointment deletedAppointment =
                appointmentDAO.findById(appointmentId);

        assertNull(deletedAppointment);
    }
}
