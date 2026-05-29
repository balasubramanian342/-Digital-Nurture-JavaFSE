import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class BasicJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "root123";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully!");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\nStudent Details:");
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(
                        id + "  " + name + "  " + age);
            }
            con.close();
        } catch (Exception e) {

            System.out.println(e);
        }
    }
}