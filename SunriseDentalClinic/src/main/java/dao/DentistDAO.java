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
import model.Dentist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinuli Disara
 */
public class DentistDAO {

    // =========================================================
    // 1. FIND DENTIST BY ID
    // =========================================================
    public Dentist findById(int dentistId) {

        String sql = "SELECT * FROM dentists WHERE dentist_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, dentistId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return mapResultSetToDentist(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================================================
    // 2. FIND DENTIST BY USER ID
    // =========================================================
    public Dentist findByUserId(int userId) {

        String sql = "SELECT * FROM dentists WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return mapResultSetToDentist(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================================================
    // 3. GET ALL DENTISTS
    // =========================================================
    public List<Dentist> getAllDentists() {

        List<Dentist> dentists = new ArrayList<>();

        String sql = "SELECT * FROM dentists ORDER BY dentist_id";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Dentist dentist = mapResultSetToDentist(resultSet);

                dentists.add(dentist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentists;
    }

    // =========================================================
    // 4. GET ACTIVE DENTISTS
    // =========================================================
    public List<Dentist> getActiveDentists() {

        List<Dentist> dentists = new ArrayList<>();

        String sql = """
                SELECT * FROM dentists
                WHERE status = 'ACTIVE'
                ORDER BY dentist_id
                """;

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Dentist dentist = mapResultSetToDentist(resultSet);

                dentists.add(dentist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentists;
    }

    // =========================================================
    // 5. INSERT DENTIST
    // =========================================================
    public boolean insertDentist(Dentist dentist) {

        String sql = """
                INSERT INTO dentists
                (user_id, name, email, contact_no,
                 specialization, consultation_fee, status)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, dentist.getUserId());
            statement.setString(2, dentist.getName());
            statement.setString(3, dentist.getEmail());
            statement.setString(4, dentist.getContactNo());
            statement.setString(5, dentist.getSpecialization());
            statement.setDouble(6, dentist.getConsultationFee());
            statement.setString(7, dentist.getStatus());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {

                try (ResultSet generatedKeys =
                             statement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {

                        dentist.setDentistId(
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
    // 6. UPDATE DENTIST
    // =========================================================
    public boolean updateDentist(Dentist dentist) {

        String sql = """
                 UPDATE dentists
                 SET user_id = ?,
                     name = ?,
                     email = ?,
                     contact_no = ?,
                     specialization = ?,
                     consultation_fee = ?,
                     status = ?
                 WHERE dentist_id = ?
                 """;

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, dentist.getUserId());
        statement.setString(2, dentist.getName());
        statement.setString(3, dentist.getEmail());
        statement.setString(4, dentist.getContactNo());
        statement.setString(5, dentist.getSpecialization());
        statement.setDouble(6, dentist.getConsultationFee());
        statement.setString(7, dentist.getStatus());
        statement.setInt(8, dentist.getDentistId());

        int rowsAffected = statement.executeUpdate();

        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("UPDATE ERROR: " + e.getMessage());
        return false;
    }
    }

    // =========================================================
    // 7. DEACTIVATE DENTIST
    // =========================================================
    public boolean deactivateDentist(int dentistId) {

        String sql = """
                UPDATE dentists
                SET status = 'INACTIVE'
                WHERE dentist_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, dentistId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 8. ACTIVATE DENTIST
    // =========================================================
    public boolean activateDentist(int dentistId) {

        String sql = """
                UPDATE dentists
                SET status = 'ACTIVE'
                WHERE dentist_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, dentistId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 9. MAP DATABASE ROW TO DENTIST OBJECT
    // =========================================================
    private Dentist mapResultSetToDentist(ResultSet resultSet)
            throws SQLException {

        int dentistId =
                resultSet.getInt("dentist_id");

        int userId =
                resultSet.getInt("user_id");

        String name =
                resultSet.getString("name");

        String email =
                resultSet.getString("email");

        String contactNo =
                resultSet.getString("contact_no");

        String specialization =
                resultSet.getString("specialization");

        double consultationFee =
                resultSet.getDouble("consultation_fee");

        String status =
                resultSet.getString("status");

        return new Dentist(
                dentistId,
                userId,
                name,
                email,
                contactNo,
                specialization,
                consultationFee,
                status
        );
    }
}
