# JDBC Example

This repository contains a Java class `DBOperations` that demonstrates basic operations using Java Database Connectivity (JDBC). It allows you to perform database operations like establishing a connection, creating tables, inserting data, deleting data, and closing the connection. This class serves as a simple demonstration of how to interact with a database using JDBC.

## Setup

To use this code, you need to have Java and a suitable database installed. Ensure that you have the JDBC driver for your specific database. Modify the JDBC URL, username, and password according to your database configuration.

## Class Functionality

The `DBOperations` class provides the following methods:
- `connection`: Establishes a connection to the database.
- `createTables`: Creates tables in the connected database based on the provided SQL query.
- `insertIntoTables`: Inserts data into the tables based on the provided SQL query.
- `deleteFromTable`: Deletes data from the table based on the provided SQL query.
- `closeConnection`: Closes the connection with the database.

Feel free to modify and expand upon the provided code to suit your specific use case.
