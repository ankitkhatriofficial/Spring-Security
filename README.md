# Spring-Security
Demo Project for Spring Boot and Spring Security

# How to Run this Application On Localhost??

 1) Download this Project
 2) Unzip the Project
 3) You will get SQL_File.sql file, open your database(mysql) and run these commands written in this .sql file or simply import this .sql file to your database and execute it.
 4) Once when the Database is ready and all records are inserted Successfully, Open your IDE (Eclipse, Netbeans, IntelliJ, etc) 
 5) Go to import section and import this project as "existing maven Project"
 6) Once when the IDE sets up everything and build maven project automatically for you, open "application.properties" (folder source- src/main/resource) and configure your             database name, user and password
 7) Now, Go to src/main/java/com/Demo/SpringSecurity and open "SpringSecurityApplication.java" file in IDE
 8) Once the file is open, Right click on the file and Run as "Java Application" and everything will setup automatically and the project will be deployed at                           http://localhost:8080 , open browser and run the application.
 9) ByDefault there are 3 users (bobby, ankit, khatri) and password for everyone is (test123)
 10) Hurray! The project is all setup, You can enjoy running it and modifying it (UI, backend etc according to your requirement)
 
 ___________________________________________
 
 # How to Store Password using encrpytion technique?
 1) Here, I am using Bcrypt encryption technique which is most recommended encrytpion technique for storing password.
 2) Follow the Above Same steps, but instead of setting up the database with "SQL_File.sql", use "encrypt_password_file.sql" file to setup the database and open                       "application.properties" and configure the database name, user and password
 3) ByDefault there are 3 users (bobby, ankit, khatri) and password for everyone is (khatri09), passwords are stored in the database in encypted form using Bcrypt encryption           technique

# Server Port Error
1) IF Error comes while running project that port 8080 is already in use 
2) Open "application.properties" (folder source- src/main/resource) and write "server.port=5431"
3) You port will be changed to 8080 to 5431, open browser and type http://localhost:5431

