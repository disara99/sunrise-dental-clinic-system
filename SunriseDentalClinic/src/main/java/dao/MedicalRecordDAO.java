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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.MedicalRecord;

public class MedicalRecordDAO {

    // =========================================================
    // 1. GET ALL MEDICAL RECORDS
    // =========================================================
    public List<MedicalRecord> getAllMedicalRecords() {

        List<MedicalRecord> records = new ArrayList<>();

        String sql = """
                SELECT *
                FROM medical_records
                ORDER BY record_id
                """;

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                records.add(mapResultSetToMedicalRecord(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }

    // =========================================================
    // 2. FIND MEDICAL RECORD BY ID
    // =========================================================
    public MedicalRecord findById(int recordId) {

        String sql = """
                SELECT *
                FROM medical_records
                WHERE record_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, recordId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return mapResultSetToMedicalRecord(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================================================
    // 3. GET RECORDS BY PATIENT
    // =========================================================
    public List<MedicalRecord> getRecordsByPatientId(int patientId) {

        List<MedicalRecord> records = new ArrayList<>();

        String sql = """
                SELECT *
                FROM medical_records
                WHERE patient_id = ?
                ORDER BY record_date DESC, record_id DESC
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, patientId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    records.add(
                            mapResultSetToMedicalRecord(resultSet)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }

    // =========================================================
    // 4. GET RECORDS BY DENTIST
    // =========================================================
    public List<MedicalRecord> getRecordsByDentistId(int dentistId) {

        List<MedicalRecord> records = new ArrayList<>();

        String sql = """
                SELECT *
                FROM medical_records
                WHERE dentist_id = ?
                ORDER BY record_date DESC, record_id DESC
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, dentistId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    records.add(
                            mapResultSetToMedicalRecord(resultSet)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }

    // =========================================================
    // 5. INSERT MEDICAL RECORD
    // =========================================================
    public boolean insertMedicalRecord(MedicalRecord record) {

        String sql = """
                INSERT INTO medical_records
                (patient_id, dentist_id, appointment_id,
                 diagnosis, treatment_notes, prescription, record_date)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(
                             sql,
                             Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, record.getPatientId());
            statement.setInt(2, record.getDentistId());
            statement.setInt(3, record.getAppointmentId());
            statement.setString(4, record.getDiagnosis());
            statement.setString(5, record.getTreatmentNotes());
            statement.setString(6, record.getPrescription());
            statement.setDate(7, record.getRecordDate());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {

                try (ResultSet generatedKeys =
                             statement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {

                        record.setRecordId(
                                generatedKeys.getInt(1)
                        );
                    }
                }

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 6. UPDATE MEDICAL RECORD
    // =========================================================
    public boolean updateMedicalRecord(MedicalRecord record) {

        String sql = """
                UPDATE medical_records
                SET patient_id = ?,
                    dentist_id = ?,
                    appointment_id = ?,
                    diagnosis = ?,
                    treatment_notes = ?,
                    prescription = ?,
                    record_date = ?
                WHERE record_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, record.getPatientId());
            statement.setInt(2, record.getDentistId());
            statement.setInt(3, record.getAppointmentId());
            statement.setString(4, record.getDiagnosis());
            statement.setString(5, record.getTreatmentNotes());
            statement.setString(6, record.getPrescription());
            statement.setDate(7, record.getRecordDate());
            statement.setInt(8, record.getRecordId());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 7. DELETE MEDICAL RECORD
    // =========================================================
    public boolean deleteMedicalRecord(int recordId) {

        String sql = """
                DELETE FROM medical_records
                WHERE record_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, recordId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 8. MAP RESULT SET TO MEDICAL RECORD
    // =========================================================
    private MedicalRecord mapResultSetToMedicalRecord(
            ResultSet resultSet) throws SQLException {

        return new MedicalRecord(
                resultSet.getInt("record_id"),
                resultSet.getInt("patient_id"),
                resultSet.getInt("dentist_id"),
                resultSet.getInt("appointment_id"),
                resultSet.getString("diagnosis"),
                resultSet.getString("treatment_notes"),
                resultSet.getString("prescription"),
                resultSet.getDate("record_date")
        );
    }
}
