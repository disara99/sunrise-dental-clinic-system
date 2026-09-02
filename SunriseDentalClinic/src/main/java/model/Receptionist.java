/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dinuli Disara
 */
public class Receptionist {

    private int receptionistId;
    private int userId;
    private String name;
    private String email;
    private String contactNo;
    private String status;

    public Receptionist() {
    }

    public Receptionist(int userId, String name, String email,
            String contactNo, String status) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.status = status;
    }

    public Receptionist(int receptionistId, int userId, String name,
            String email, String contactNo, String status) {

        this.receptionistId = receptionistId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.status = status;
    }

    public int getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(int receptionistId) {
        this.receptionistId = receptionistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
