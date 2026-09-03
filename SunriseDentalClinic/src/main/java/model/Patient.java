/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dinuli Disara
 */
import java.sql.Date;

public class Patient {

    private int patientId;
    private String name;
    private String address;
    private String contactNo;
    private Date dateOfBirth;
    private String gender;

    public Patient() {
    }

    public Patient(int patientId, String name, String address,
                   String contactNo, Date dateOfBirth, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}