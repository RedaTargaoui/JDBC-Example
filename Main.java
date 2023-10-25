public class Main {
    public static void main(String[] args) {

        DBOperations dbOperations = new DBOperations();
        // Connect to database :
        dbOperations.connection("jdbc:mysql://localhost:3306/database_name", "username", "password");
        // Create tables :
        dbOperations.createTables("SQL query to create a table");
        // Insert into tables :
        dbOperations.insertIntoTables("SQL query to insert into a table");
        // Delete from tables :
        dbOperations.deleteFromTable("SQL query to delete from a table");
        // CLose connection :
        dbOperations.closeConnection();

    }
}
