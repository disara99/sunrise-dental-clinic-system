/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dinuli Disara
 */
public class Treatment {

    private int treatmentId;
    private String treatmentName;
    private String description;
    private double treatmentFee;
    private String status;

    // Default constructor
    public Treatment() {
    }

    // Constructor without treatmentId
    // Used when adding a new treatment
    public Treatment(String treatmentName,
                     String description,
                     double treatmentFee,
                     String status) {

        this.treatmentName = treatmentName;
        this.description = description;
        this.treatmentFee = treatmentFee;
        this.status = status;
    }

    // Full constructor
    // Used when retrieving a treatment from database
    public Treatment(int treatmentId,
                     String treatmentName,
                     String description,
                     double treatmentFee,
                     String status) {

        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.description = description;
        this.treatmentFee = treatmentFee;
        this.status = status;
    }

    // Getter and Setter for treatmentId
    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    // Getter and Setter for treatmentName
    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for treatmentFee
    public double getTreatmentFee() {
        return treatmentFee;
    }

    public void setTreatmentFee(double treatmentFee) {
        this.treatmentFee = treatmentFee;
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
        return "Treatment{" +
                "treatmentId=" + treatmentId +
                ", treatmentName='" + treatmentName + '\'' +
                ", description='" + description + '\'' +
                ", treatmentFee=" + treatmentFee +
                ", status='" + status + '\'' +
                '}';
    }
    
}
