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
     */
    public void createTables() {
        try {
            String sql1 = "CREATE TABLE IF NOT EXISTS Fournisseurs (" +
                    "CodeFournisseur INT NOT NULL PRIMARY KEY," +
                    "Nom VARCHAR(50) NOT NULL," +
                    "Adresse VARCHAR(50) NOT NULL," +
                    "Ville VARCHAR(50) NOT NULL" +
                    ")";
            statement.executeUpdate(sql1);
            System.out.println("Table Fournisseurs created successfully.");


            String sql2 = "CREATE TABLE IF NOT EXISTS Produits (" +
                    "CodeProduit INT NOT NULL PRIMARY KEY," +
                    "Type VARCHAR(50) NOT NULL," +
                    "Marque VARCHAR(50) NOT NULL," +
                    "Modèle VARCHAR(50) NOT NULL" +
                    ")";

            statement.executeUpdate(sql2);
            System.out.println("Table Produits created successfully.");


            String sql3 = "CREATE TABLE IF NOT EXISTS Catalogue (" +
                    "Fournisseur INT NOT NULL," +
                    "Produit INT NOT NULL," +
                    "Prix DOUBLE NOT NULL," +
                    "PRIMARY KEY (Fournisseur,Produit)," +
                    "FOREIGN KEY(Fournisseur) REFERENCES Fournisseurs(CodeFournisseur)," +
                    "FOREIGN KEY(Produit) REFERENCES Produits(CodeProduit)" +
                    ")";
            statement.executeUpdate(sql3);
            System.out.println("Table Catalogue created successfully.");

        } catch (SQLException e) {
            System.out.println("Table creation failed");
            e.printStackTrace();
        }
    }

    /**
     * Insert into tables
     */
    public void insertIntoTables() {
        try {
            String insertData = "INSERT INTO Fournisseurs (CodeFournisseur, Nom, Adresse, Ville) VALUES " +
                    "('001', 'Dubois', 'Rue Paul Bert', 'Paris'), " +
                    "('002', 'Dupont', 'Avenue Générale De Gaulle', 'Toulouse')," +
                    "('010', 'Cuissart', 'Rue Vaugirard', 'Lyon')";

            statement.executeUpdate(insertData);
            System.out.println("Data inserted into Fournisseurs table.");
        } catch (SQLException e) {
            System.out.println("Insertion failed");
            e.printStackTrace();
        }
    }

    /**
     * Delete a row in the table
     */
    public void deleteFromTable() {
        try {
            String deleteData = "DELETE FROM Produits WHERE Marque = 'peugeot'";

            statement.executeUpdate(deleteData);
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
