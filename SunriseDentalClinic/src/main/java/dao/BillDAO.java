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
import model.Bill;

public class BillDAO {

    // =========================================================
    // 1. GET ALL BILLS
    // =========================================================
    public List<Bill> getAllBills() {

        List<Bill> bills = new ArrayList<>();

        String sql = """
                SELECT *
                FROM bills
                ORDER BY bill_id
                """;

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                bills.add(mapResultSetToBill(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }

    // =========================================================
    // 2. FIND BILL BY ID
    // =========================================================
    public Bill findById(int billId) {

        String sql = """
                SELECT *
                FROM bills
                WHERE bill_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, billId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return mapResultSetToBill(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================================================
    // 3. FIND BILL BY APPOINTMENT ID
    // =========================================================
    public Bill findByAppointmentId(int appointmentId) {

        String sql = """
                SELECT *
                FROM bills
                WHERE appointment_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, appointmentId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return mapResultSetToBill(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================================================
    // 4. INSERT BILL
    // =========================================================
    public boolean insertBill(Bill bill) {

        String sql = """
                INSERT INTO bills
                (appointment_id, consultation_fee, treatment_fee,
                 total_amount, payment_status, bill_date)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, bill.getAppointmentId());
            statement.setDouble(2, bill.getConsultationFee());
            statement.setDouble(3, bill.getTreatmentFee());
            statement.setDouble(4, bill.getTotalAmount());
            statement.setString(5, bill.getPaymentStatus());
            statement.setDate(6, bill.getBillDate());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {

                try (ResultSet generatedKeys =
                             statement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {
                        bill.setBillId(generatedKeys.getInt(1));
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
    // 5. UPDATE BILL
    // =========================================================
    public boolean updateBill(Bill bill) {

        String sql = """
                UPDATE bills
                SET appointment_id = ?,
                    consultation_fee = ?,
                    treatment_fee = ?,
                    total_amount = ?,
                    payment_status = ?,
                    bill_date = ?
                WHERE bill_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bill.getAppointmentId());
            statement.setDouble(2, bill.getConsultationFee());
            statement.setDouble(3, bill.getTreatmentFee());
            statement.setDouble(4, bill.getTotalAmount());
            statement.setString(5, bill.getPaymentStatus());
            statement.setDate(6, bill.getBillDate());
            statement.setInt(7, bill.getBillId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 6. UPDATE PAYMENT STATUS
    // =========================================================
    public boolean updatePaymentStatus(
            int billId,
            String paymentStatus) {

        String sql = """
                UPDATE bills
                SET payment_status = ?
                WHERE bill_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, paymentStatus);
            statement.setInt(2, billId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 7. DELETE BILL
    // =========================================================
    public boolean deleteBill(int billId) {

        String sql = """
                DELETE FROM bills
                WHERE bill_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, billId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================================================
    // 8. MAP RESULT SET TO BILL
    // =========================================================
    private Bill mapResultSetToBill(ResultSet resultSet)
            throws SQLException {

        return new Bill(
                resultSet.getInt("bill_id"),
                resultSet.getInt("appointment_id"),
                resultSet.getDouble("consultation_fee"),
                resultSet.getDouble("treatment_fee"),
                resultSet.getDouble("total_amount"),
                resultSet.getString("payment_status"),
                resultSet.getDate("bill_date")
        );
    }
}
