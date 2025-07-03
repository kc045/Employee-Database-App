<h1>---Employee Database Management App (Java + JDBC)---</h1>
<br>
This is a Java console-based application that connects to a MySQL database using JDBC (Java Database Connectivity) to perform basic CRUD operations (Create, Read, Update, Delete) on employee records.

It is designed as a simple learning project to understand how Java applications interact with relational databases.

<h3>Features</h3>

➕ Add a new employee (with ID, name, email, salary)

📄 View all employee records

✏️ Update an existing employee

❌ Delete an employee by ID

🔐 Uses PreparedStatement to prevent SQL injection

👨‍💻 Fully CLI-based interaction using Java Scanner

 <h3>Database Setup</h3>
 
Before running the application, ensure you have the following MySQL database setup:
CREATE DATABASE student;

USE student;

CREATE TABLE demo (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    salary DOUBLE
);

<h3>Database Connection Configuration</h3>
In the Employee.java file, update your database credentials:
static String url = "jdbc:mysql://localhost:3306/student";
static String username = "root";
static String password = "your_password_here";
<h2>Methods to perform operations</h2>
addEmployee() – inserts a new record into the demo table

viewEmployee() – displays all employees

updateEmployee() – updates employee details by ID

deleteEmployee() – removes an employee record using ID
</br>
