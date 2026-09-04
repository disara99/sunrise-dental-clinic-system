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
import model.Appointment;

public class AppointmentDAO {

    // Get all appointments
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments ORDER BY appointment_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        rs.getInt("appointment_id"));

                appointment.setAppointmentNo(
                        rs.getString("appointment_no"));

                appointment.setPatientId(
                        rs.getInt("patient_id"));

                appointment.setDentistId(
                        rs.getInt("dentist_id"));

                appointment.setTreatmentId(
                        rs.getInt("treatment_id"));

                appointment.setAppointmentDate(
                        rs.getDate("appointment_date"));

                appointment.setAppointmentTime(
                        rs.getTime("appointment_time"));

                appointment.setStatus(
                        rs.getString("status"));

                appointment.setCreatedBy(
                        rs.getInt("created_by"));

                appointments.add(appointment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }
    // =========================================================
// GET APPOINTMENTS BY DENTIST
// =========================================================
public List<Appointment> getAppointmentsByDentistId(int dentistId) {

    List<Appointment> appointments = new ArrayList<>();

    String sql = """
            SELECT * FROM appointments
            WHERE dentist_id = ?
            ORDER BY appointment_date, appointment_time
            """;

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, dentistId);

        try (ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        resultSet.getInt("appointment_id"));

                appointment.setAppointmentNo(
                        resultSet.getString("appointment_no"));

                appointment.setPatientId(
                        resultSet.getInt("patient_id"));

                appointment.setDentistId(
                        resultSet.getInt("dentist_id"));

                appointment.setTreatmentId(
                        resultSet.getInt("treatment_id"));

                appointment.setAppointmentDate(
                        resultSet.getDate("appointment_date"));

                appointment.setAppointmentTime(
                        resultSet.getTime("appointment_time"));

                appointment.setStatus(
                        resultSet.getString("status"));

                appointment.setCreatedBy(
                        resultSet.getInt("created_by"));

                appointments.add(appointment);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return appointments;
}

    // Find appointment by ID
    public Appointment findById(int appointmentId) {

        String sql =
                "SELECT * FROM appointments WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointmentId);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Appointment appointment = new Appointment();

                    appointment.setAppointmentId(
                            rs.getInt("appointment_id"));

                    appointment.setAppointmentNo(
                            rs.getString("appointment_no"));

                    appointment.setPatientId(
                            rs.getInt("patient_id"));

                    appointment.setDentistId(
                            rs.getInt("dentist_id"));

                    appointment.setTreatmentId(
                            rs.getInt("treatment_id"));

                    appointment.setAppointmentDate(
                            rs.getDate("appointment_date"));

                    appointment.setAppointmentTime(
                            rs.getTime("appointment_time"));

                    appointment.setStatus(
                            rs.getString("status"));

                    appointment.setCreatedBy(
                            rs.getInt("created_by"));

                    return appointment;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Insert appointment
    public boolean insertAppointment(Appointment appointment) {

        String sql =
                "INSERT INTO appointments "
                + "(appointment_no, patient_id, dentist_id, treatment_id, "
                + "appointment_date, appointment_time, status, created_by) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, appointment.getAppointmentNo());
            stmt.setInt(2, appointment.getPatientId());
            stmt.setInt(3, appointment.getDentistId());
            stmt.setInt(4, appointment.getTreatmentId());
            stmt.setDate(5, appointment.getAppointmentDate());
            stmt.setTime(6, appointment.getAppointmentTime());
            stmt.setString(7, appointment.getStatus());
            stmt.setInt(8, appointment.getCreatedBy());

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                try (ResultSet rs = stmt.getGeneratedKeys()) {

                    if (rs.next()) {
                        appointment.setAppointmentId(rs.getInt(1));
                    }
                }

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update appointment
    public boolean updateAppointment(Appointment appointment) {

        String sql =
                "UPDATE appointments SET "
                + "appointment_no = ?, "
                + "patient_id = ?, "
                + "dentist_id = ?, "
                + "treatment_id = ?, "
                + "appointment_date = ?, "
                + "appointment_time = ?, "
                + "status = ?, "
                + "created_by = ? "
                + "WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, appointment.getAppointmentNo());
            stmt.setInt(2, appointment.getPatientId());
            stmt.setInt(3, appointment.getDentistId());
            stmt.setInt(4, appointment.getTreatmentId());
            stmt.setDate(5, appointment.getAppointmentDate());
            stmt.setTime(6, appointment.getAppointmentTime());
            stmt.setString(7, appointment.getStatus());
            stmt.setInt(8, appointment.getCreatedBy());
            stmt.setInt(9, appointment.getAppointmentId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update appointment status only
    public boolean updateStatus(int appointmentId, String status) {

        String sql =
                "UPDATE appointments SET status = ? "
                + "WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, appointmentId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete appointment
    public boolean deleteAppointment(int appointmentId) {

        String sql =
                "DELETE FROM appointments WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointmentId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
