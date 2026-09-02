/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dinuli Disara
 */
public class Dentist {

    private int dentistId;
    private int userId;
    private String name;
    private String email;
    private String contactNo;
    private String specialization;
    private double consultationFee;
    private String status;

    // Default constructor
    public Dentist() {
    }

    // Constructor without dentistId
    // Used when adding a new dentist
    public Dentist(int userId,
                   String name,
                   String email,
                   String contactNo,
                   String specialization,
                   double consultationFee,
                   String status) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.status = status;
    }

    // Full constructor
    // Used when retrieving a dentist from the database
    public Dentist(int dentistId,
                   int userId,
                   String name,
                   String email,
                   String contactNo,
                   String specialization,
                   double consultationFee,
                   String status) {

        this.dentistId = dentistId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.status = status;
    }

    // Getter and Setter for dentistId
    public int getDentistId() {
        return dentistId;
    }

    public void setDentistId(int dentistId) {
        this.dentistId = dentistId;
    }

    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for contactNo
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    // Getter and Setter for specialization
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Getter and Setter for consultationFee
    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentistId=" + dentistId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", specialization='" + specialization + '\'' +
                ", consultationFee=" + consultationFee +
                ", status='" + status + '\'' +
                '}';
    }
}
