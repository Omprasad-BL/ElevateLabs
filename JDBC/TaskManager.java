import java.sql.*;

public class TaskManager {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "fdcr";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database.");

            // Add a task
            addTask(conn, "Learn JDBC");

            // View all tasks
            viewTasks(conn);

            // Update a task
            updateTask(conn, 1, "Learn JDBC in Java");

            // View all tasks again
            viewTasks(conn);

            // Delete a task
            deleteTask(conn, 1);

            // View all tasks again
            viewTasks(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(Connection conn, String description) throws SQLException {
        String sql = "INSERT INTO tasks (description) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, description);
            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " task(s) added.");
        }
    }

    public static void viewTasks(Connection conn) throws SQLException {
        String sql = "SELECT * FROM tasks";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Task List:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                System.out.println(id + ": " + description);
            }
        }
    }

    public static void updateTask(Connection conn, int id, String newDescription) throws SQLException {
        String sql = "UPDATE tasks SET description = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newDescription);
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " task(s) updated.");
        }
    }

    public static void deleteTask(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " task(s) deleted.");
        }
    }
}
