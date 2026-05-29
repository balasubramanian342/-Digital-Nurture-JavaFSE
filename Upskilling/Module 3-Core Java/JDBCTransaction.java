import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTransaction {

    static final String URL =
            "jdbc:mysql://localhost:3306/testdb";

    static final String USER = "root";

    static final String PASSWORD = "root123";

    public void transferMoney(int fromAccount,
                              int toAccount,
                              double amount) {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            con.setAutoCommit(false);

            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?";

            PreparedStatement debitStmt =
                    con.prepareStatement(debitQuery);

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);

            int debitRows = debitStmt.executeUpdate();

            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement creditStmt =
                    con.prepareStatement(creditQuery);

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);

            int creditRows = creditStmt.executeUpdate();

            if (debitRows > 0 && creditRows > 0) {

                con.commit();

                System.out.println("Transaction Successful");

            } else {

                con.rollback();

                System.out.println("Transaction Failed");
            }

            con.setAutoCommit(true);

            con.close();

        } catch (Exception e) {

            try {

                if (con != null) {

                    con.rollback();

                    System.out.println("Transaction Rolled Back");
                }

            } catch (Exception ex) {

                System.out.println(ex);
            }

            System.out.println(e);
        }
    }

    public void displayAccounts() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            URL, USER, PASSWORD);

            String query = "SELECT * FROM accounts";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nAccount Details");
            System.out.println("--------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");

                System.out.println(
                        id + "  " + name + "  " + balance);
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        JDBCTransaction obj =
                new JDBCTransaction();

        System.out.println("Before Transaction");

        obj.displayAccounts();

        obj.transferMoney(1, 2, 1000);

        System.out.println("\nAfter Transaction");

        obj.displayAccounts();
    }
}