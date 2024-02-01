# Student-Result-Management-System
 Student Result Management System This is a Single Page App (SPA) for Student Result Management System implemented using Java Spring Boot for the backend, Thymeleaf for processing pages, and H2 database .

Prerequisites
IDE [Ecllipse, VSCode]
Java JDK 8 or later installed.
Maven build tool installed.
Spring boot dependies from IDE [Spring Web, Spring Devtools, H2 Databse, Mysql Driver, ThymeLeaf, Lombok, Spring Data JDBC].

Getting Started:-

Clone the Repository:
Copy code
git clone https://github.com/yourusername/student-result-management.git
cd student-result-management


Build the Application:
Copy code
mvn clean install

Run the Application:
Copy code
java -jar target/student-result-management-0.0.1-SNAPSHOT.jar
The application will start at http://localhost:8080.

Features
Student Registration:

Navigate to http://localhost:8080/addStudent.
Fill in the student details and click "Add Student."
Result Entry:


Database
This application uses an H2 in-memory database for temporary storage. You can access the H2 console at http://localhost:8080/h2-console. JDBC URL: jdbc:h2:mem:testdb, Username: sa, Password: (leave blank).

Troubleshooting
If you encounter any issues, ensure that Java and Maven are properly configured.
Check the console logs for error messages.
