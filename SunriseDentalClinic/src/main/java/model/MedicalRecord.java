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

public class MedicalRecord {

    private int recordId;
    private int patientId;
    private int dentistId;
    private int appointmentId;
    private String diagnosis;
    private String treatmentNotes;
    private String prescription;
    private Date recordDate;

    public MedicalRecord() {
    }

    public MedicalRecord(
            int recordId,
            int patientId,
            int dentistId,
            int appointmentId,
            String diagnosis,
            String treatmentNotes,
            String prescription,
            Date recordDate) {

        this.recordId = recordId;
        this.patientId = patientId;
        this.dentistId = dentistId;
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
        this.prescription = prescription;
        this.recordDate = recordDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDentistId() {
        return dentistId;
    }

    public void setDentistId(int dentistId) {
        this.dentistId = dentistId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}
