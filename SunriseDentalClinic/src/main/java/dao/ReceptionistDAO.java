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
import model.Receptionist;

public class ReceptionistDAO {

    // =========================================================
    // GET ALL RECEPTIONISTS
    // =========================================================
    public List<Receptionist> getAllReceptionists() {

        List<Receptionist> receptionists = new ArrayList<>();

        String sql = "SELECT * FROM receptionists ORDER BY receptionist_id";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Receptionist receptionist = new Receptionist(
                        resultSet.getInt("receptionist_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("contact_no"),
                        resultSet.getString("status")
                );

                receptionists.add(receptionist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receptionists;
    }

    // =========================================================
    // INSERT RECEPTIONIST
    // =========================================================
    public boolean insertReceptionist(Receptionist receptionist) {

        String sql = """
                INSERT INTO receptionists
                (user_id, name, email, contact_no, status)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, receptionist.getUserId());
            statement.setString(2, receptionist.getName());
            statement.setString(3, receptionist.getEmail());
            statement.setString(4, receptionist.getContactNo());
            statement.setString(5, receptionist.getStatus());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {

                try (ResultSet generatedKeys =
                             statement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {

                        receptionist.setReceptionistId(
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
    // UPDATE RECEPTIONIST
    // =========================================================
    public boolean updateReceptionist(Receptionist receptionist) {

        String sql = """
                UPDATE receptionists
                SET user_id = ?,
                    name = ?,
                    email = ?,
                    contact_no = ?,
                    status = ?
                WHERE receptionist_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, receptionist.getUserId());
            statement.setString(2, receptionist.getName());
            statement.setString(3, receptionist.getEmail());
            statement.setString(4, receptionist.getContactNo());
            statement.setString(5, receptionist.getStatus());
            statement.setInt(6, receptionist.getReceptionistId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // DEACTIVATE RECEPTIONIST
    // =========================================================
    public boolean deactivateReceptionist(int receptionistId) {

        String sql = """
                UPDATE receptionists
                SET status = 'INACTIVE'
                WHERE receptionist_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, receptionistId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
