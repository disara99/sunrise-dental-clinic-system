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
import model.Treatment;

public class TreatmentDAO {

    // =========================================================
    // GET ALL TREATMENTS
    // =========================================================
    public List<Treatment> getAllTreatments() {

        List<Treatment> treatments = new ArrayList<>();

        String sql = "SELECT * FROM treatments ORDER BY treatment_id";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Treatment treatment = new Treatment(
                        resultSet.getInt("treatment_id"),
                        resultSet.getString("treatment_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("treatment_fee"),
                        resultSet.getString("status")
                );

                treatments.add(treatment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treatments;
    }

    // =========================================================
    // INSERT TREATMENT
    // =========================================================
    public boolean insertTreatment(Treatment treatment) {

        String sql = """
                INSERT INTO treatments
                (treatment_name, description, treatment_fee, status)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, treatment.getTreatmentName());
            statement.setString(2, treatment.getDescription());
            statement.setDouble(3, treatment.getTreatmentFee());
            statement.setString(4, treatment.getStatus());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {

                try (ResultSet generatedKeys =
                             statement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {
                        treatment.setTreatmentId(
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
    // UPDATE TREATMENT
    // =========================================================
    public boolean updateTreatment(Treatment treatment) {

        String sql = """
                UPDATE treatments
                SET treatment_name = ?,
                    description = ?,
                    treatment_fee = ?,
                    status = ?
                WHERE treatment_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, treatment.getTreatmentName());
            statement.setString(2, treatment.getDescription());
            statement.setDouble(3, treatment.getTreatmentFee());
            statement.setString(4, treatment.getStatus());
            statement.setInt(5, treatment.getTreatmentId());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // DEACTIVATE TREATMENT
    // =========================================================
    public boolean deactivateTreatment(int treatmentId) {

        String sql = """
                UPDATE treatments
                SET status = 'INACTIVE'
                WHERE treatment_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, treatmentId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    // =========================================================
// FIND TREATMENT BY ID
// =========================================================
public Treatment findById(int treatmentId) {

    String sql = "SELECT * FROM treatments WHERE treatment_id = ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, treatmentId);

        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {

                return new Treatment(
                        resultSet.getInt("treatment_id"),
                        resultSet.getString("treatment_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("treatment_fee"),
                        resultSet.getString("status")
                );
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}
