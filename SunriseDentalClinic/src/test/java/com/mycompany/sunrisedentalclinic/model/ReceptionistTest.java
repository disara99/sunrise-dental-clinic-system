/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sunrisedentalclinic.model;

/**
 *
 * @author Dinuli Disara
 */
import model.Receptionist;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceptionistTest {

    @Test
    public void testReceptionistConstructorAndGetters() {

        Receptionist receptionist = new Receptionist(
                1,
                2,
                "Amila Silva",
                "amila@gmail.com",
                "0712345678",
                "ACTIVE"
        );

        assertEquals(1, receptionist.getReceptionistId());
        assertEquals(2, receptionist.getUserId());
        assertEquals("Amila Silva", receptionist.getName());
        assertEquals("amila@gmail.com", receptionist.getEmail());
        assertEquals("0712345678", receptionist.getContactNo());
        assertEquals("ACTIVE", receptionist.getStatus());
    }

    @Test
    public void testSetters() {

        Receptionist receptionist = new Receptionist();

        receptionist.setReceptionistId(1);
        receptionist.setUserId(2);
        receptionist.setName("Amila Silva");
        receptionist.setEmail("amila@gmail.com");
        receptionist.setContactNo("0712345678");
        receptionist.setStatus("ACTIVE");

        assertEquals(1, receptionist.getReceptionistId());
        assertEquals(2, receptionist.getUserId());
        assertEquals("Amila Silva", receptionist.getName());
        assertEquals("amila@gmail.com", receptionist.getEmail());
        assertEquals("0712345678", receptionist.getContactNo());
        assertEquals("ACTIVE", receptionist.getStatus());
    }
}
