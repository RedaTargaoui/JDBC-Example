public class Main {
    public static void main(String[] args) {

        DBOperations dbOperations = new DBOperations();
        // Connect to database :
        dbOperations.connection("jdbc:mysql://localhost:3306/BDD_OOL_TP1", "root", "root");
        // Create tables :
        dbOperations.createTables();
        // Insert into tables :
        dbOperations.insertIntoTables();
        // Delete from tables :
        dbOperations.deleteFromTable();
        // CLose connection :
        dbOperations.closeConnection();

    }
}
