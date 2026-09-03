/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinuli Disara
 */
import com.mycompany.sunrisedentalclinic.db.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

public class PatientDAO {

    // Get all patients
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM patients ORDER BY patient_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setAddress(rs.getString("address"));
                patient.setContactNo(rs.getString("contact_no"));
                patient.setDateOfBirth(rs.getDate("date_of_birth"));
                patient.setGender(rs.getString("gender"));

                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    // Get patient by ID
    public Patient findById(int patientId) {

        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Patient patient = new Patient();

                    patient.setPatientId(rs.getInt("patient_id"));
                    patient.setName(rs.getString("name"));
                    patient.setAddress(rs.getString("address"));
                    patient.setContactNo(rs.getString("contact_no"));
                    patient.setDateOfBirth(rs.getDate("date_of_birth"));
                    patient.setGender(rs.getString("gender"));

                    return patient;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Insert patient
    public boolean insertPatient(Patient patient) {

        String sql = "INSERT INTO patients "
                + "(name, address, contact_no, date_of_birth, gender) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getAddress());
            stmt.setString(3, patient.getContactNo());
            stmt.setDate(4, patient.getDateOfBirth());
            stmt.setString(5, patient.getGender());

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                try (ResultSet rs = stmt.getGeneratedKeys()) {

                    if (rs.next()) {
                        patient.setPatientId(rs.getInt(1));
                    }
                }

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update patient
    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE patients SET "
                + "name = ?, "
                + "address = ?, "
                + "contact_no = ?, "
                + "date_of_birth = ?, "
                + "gender = ? "
                + "WHERE patient_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getAddress());
            stmt.setString(3, patient.getContactNo());
            stmt.setDate(4, patient.getDateOfBirth());
            stmt.setString(5, patient.getGender());
            stmt.setInt(6, patient.getPatientId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete patient
    public boolean deletePatient(int patientId) {

        String sql = "DELETE FROM patients WHERE patient_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
