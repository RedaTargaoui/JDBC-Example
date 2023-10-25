import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
    // Attributes :
    private Connection connection;
    private Statement statement;

    /**
     * Initialise connection to database
     * @param jdbcURL url to database
     * @param username username
     * @param password password
     */
    public void connection(String jdbcURL, String username, String password) {
        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected successfully.");

            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    /**
     * Create tables
     * @param query SQL query to create a table in the database
     */
    public void createTables(String query) {
        try {
            statement.executeUpdate(query);
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.out.println("Table creation failed");
            e.printStackTrace();
        }
    }

    /**
     * Insert into tables
     * @param query SQL query to insert into a table
     */
    public void insertIntoTables(String query) {
        try {
            statement.executeUpdate(query);
            System.out.println("Data inserted into table.");
        } catch (SQLException e) {
            System.out.println("Insertion failed");
            e.printStackTrace();
        }
    }

    /**
     * Delete a row in the table
     * @param query SQL query to delete from a table
     */
    public void deleteFromTable(String query) {
        try {
            statement.executeUpdate(query);
            System.out.println("Data deleted from Produits table.");
        } catch (SQLException e) {
            System.out.println("Deletion failed");
            e.printStackTrace();
        }
    }

    /**
     * Close connection
     */
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            System.out.println("Error while closing connection!");
            e.printStackTrace();
        }
    }
}
