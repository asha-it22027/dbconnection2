import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    public void addStudent(String name) {
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "INSERT INTO student(name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(int id) {
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted." : "No student found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyStudent(int id, String newName) {
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "UPDATE student SET name = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student updated." : "No student found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StudentEntity findStudent(int id) {
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "SELECT * FROM student WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new StudentEntity(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<StudentEntity> listStudents() {
        List<StudentEntity> list = new ArrayList<>();
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "SELECT * FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new StudentEntity(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}