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
import model.Bill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BillTest {

    @Test
    void testBillCreation() {

        Date billDate = Date.valueOf("2026-09-04");

        Bill bill = new Bill(
                1,
                5,
                3000.00,
                5000.00,
                8000.00,
                "PENDING",
                billDate
        );

        assertEquals(1, bill.getBillId());
        assertEquals(5, bill.getAppointmentId());
        assertEquals(3000.00, bill.getConsultationFee());
        assertEquals(5000.00, bill.getTreatmentFee());
        assertEquals(8000.00, bill.getTotalAmount());
        assertEquals("PENDING", bill.getPaymentStatus());
        assertEquals(billDate, bill.getBillDate());
    }

    @Test
    void testSetters() {

        Bill bill = new Bill();

        Date billDate = Date.valueOf("2026-09-05");

        bill.setBillId(2);
        bill.setAppointmentId(6);
        bill.setConsultationFee(4000.00);
        bill.setTreatmentFee(6000.00);
        bill.setTotalAmount(10000.00);
        bill.setPaymentStatus("PAID");
        bill.setBillDate(billDate);

        assertEquals(2, bill.getBillId());
        assertEquals(6, bill.getAppointmentId());
        assertEquals(4000.00, bill.getConsultationFee());
        assertEquals(6000.00, bill.getTreatmentFee());
        assertEquals(10000.00, bill.getTotalAmount());
        assertEquals("PAID", bill.getPaymentStatus());
        assertEquals(billDate, bill.getBillDate());
    }

    @Test
    void testTotalAmountCalculation() {

        double consultationFee = 3500.00;
        double treatmentFee = 4500.00;

        double totalAmount =
                consultationFee + treatmentFee;

        assertEquals(8000.00, totalAmount);
    }
}
