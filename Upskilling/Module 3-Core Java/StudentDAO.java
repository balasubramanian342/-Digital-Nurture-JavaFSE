import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    static final String URL =
            "jdbc:mysql://localhost:3306/testdb";

    static final String USER = "root";

    static final String PASSWORD = "root123";

    public void insertStudent(int id, String name, int age) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            String query =
                    "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record inserted.");

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void updateStudent(int id, String newName, int newAge) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            String query =
                    "UPDATE students SET name=?, age=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, newName);
            ps.setInt(2, newAge);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record updated.");

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void displayStudents() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "SELECT * FROM students";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nStudent Details");
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

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.insertStudent(1, "John", 20);

        dao.insertStudent(2, "Priya", 21);

        dao.updateStudent(1, "John David", 22);

        dao.displayStudents();
    }
}