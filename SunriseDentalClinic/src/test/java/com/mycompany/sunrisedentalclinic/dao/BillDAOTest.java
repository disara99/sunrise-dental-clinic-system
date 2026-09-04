/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.dao;

/**
 *
 * @author Dinuli Disara
 */
import dao.BillDAO;
import model.Bill;

import java.sql.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BillDAOTest {

    private final BillDAO billDAO = new BillDAO();

    @Test
    void testGetAllBills() {

        assertNotNull(billDAO.getAllBills());
    }

    @Test
    void testInsertBill() {

        int appointmentId = getAvailableAppointmentId();

        if (appointmentId == -1) {
            return;
        }

        Bill bill = new Bill(
                0,
                appointmentId,
                3000.00,
                5000.00,
                8000.00,
                "PENDING",
                Date.valueOf("2026-09-05")
        );

        // The bills table allows only one bill per appointment.
        if (billDAO.findByAppointmentId(appointmentId) != null) {
            return;
        }

        boolean result = billDAO.insertBill(bill);

        assertTrue(result);
        assertTrue(bill.getBillId() > 0);
    }

    @Test
    void testFindByAppointmentId() {

        var bills = billDAO.getAllBills();

        if (bills.isEmpty()) {
            return;
        }

        Bill existingBill = bills.get(0);

        Bill found =
                billDAO.findByAppointmentId(
                        existingBill.getAppointmentId()
                );

        assertNotNull(found);
        assertEquals(
                existingBill.getBillId(),
                found.getBillId()
        );
    }

    @Test
    void testUpdateBill() {

        int appointmentId = getAvailableAppointmentId();

        if (appointmentId == -1) {
            return;
        }

        // If a bill already exists for this appointment,
        // use the existing bill instead.
        Bill bill =
                billDAO.findByAppointmentId(appointmentId);

        if (bill == null) {

            bill = new Bill(
                    0,
                    appointmentId,
                    3000.00,
                    5000.00,
                    8000.00,
                    "PENDING",
                    Date.valueOf("2026-09-06")
            );

            boolean inserted = billDAO.insertBill(bill);

            assertTrue(inserted);
            assertTrue(bill.getBillId() > 0);
        }

        bill.setConsultationFee(3500.00);
        bill.setTreatmentFee(5500.00);
        bill.setTotalAmount(9000.00);
        bill.setPaymentStatus("PAID");

        boolean updated =
                billDAO.updateBill(bill);

        assertTrue(updated);

        Bill updatedBill =
                billDAO.findById(bill.getBillId());

        assertNotNull(updatedBill);

        assertEquals(
                3500.00,
                updatedBill.getConsultationFee()
        );

        assertEquals(
                5500.00,
                updatedBill.getTreatmentFee()
        );

        assertEquals(
                9000.00,
                updatedBill.getTotalAmount()
        );

        assertEquals(
                "PAID",
                updatedBill.getPaymentStatus()
        );
    }

    @Test
    void testUpdatePaymentStatus() {

        var bills = billDAO.getAllBills();

        if (bills.isEmpty()) {
            return;
        }

        Bill bill = bills.get(0);

        boolean result =
                billDAO.updatePaymentStatus(
                        bill.getBillId(),
                        "PAID"
                );

        assertTrue(result);

        Bill updated =
                billDAO.findById(
                        bill.getBillId()
                );

        assertNotNull(updated);
        assertEquals(
                "PAID",
                updated.getPaymentStatus()
        );
    }

    @Test
    void testDeleteBill() {

        int appointmentId = getAvailableAppointmentId();

        if (appointmentId == -1) {
            return;
        }

        Bill bill =
                billDAO.findByAppointmentId(appointmentId);

        if (bill == null) {

            bill = new Bill(
                    0,
                    appointmentId,
                    3000.00,
                    4000.00,
                    7000.00,
                    "PENDING",
                    Date.valueOf("2026-09-07")
            );

            boolean inserted =
                    billDAO.insertBill(bill);

            assertTrue(inserted);
        }

        int billId = bill.getBillId();

        boolean deleted =
                billDAO.deleteBill(billId);

        assertTrue(deleted);

        assertNull(
                billDAO.findById(billId)
        );
    }

    // =========================================================
    // FIND AN AVAILABLE APPOINTMENT ID
    // =========================================================
    private int getAvailableAppointmentId() {

        try {

            dao.AppointmentDAO appointmentDAO =
                    new dao.AppointmentDAO();

            var appointments =
                    appointmentDAO.getAllAppointments();

            if (appointments.isEmpty()) {
                return -1;
            }

            return appointments.get(0).getAppointmentId();

        } catch (Exception e) {

            e.printStackTrace();
            return -1;
        }
    }
}
