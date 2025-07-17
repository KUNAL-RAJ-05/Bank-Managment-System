# Bank Management System (ATM Simulator)

This project is a Java-based Bank Management System, also referred to as an ATM Simulator System. It provides a hands-on, project-based approach to understanding core banking functionalities and their implementation using Java and MySQL.

## 🚀 Project Overview

The system mimics real-world ATM functionalities, allowing users to perform various banking operations. This project serves as a comprehensive learning resource for building a full-stack Java application with database integration.

## ✨ Features

The ATM Simulator system supports the following key functionalities:

* **Account Opening:** Users can register and open new bank accounts.
* **Deposits:** Deposit money into an existing account.
* **Withdrawals:** Withdraw money from an existing account.
* **Mini Statements:** View a concise summary of recent transactions.
* **PIN Changes:** Securely change the ATM PIN.
* **Login/Authentication:** Secure access to account features.

## 💻 Technology Stack

* **Frontend/GUI:** Java (Swing/AWT)
* **Backend/Application Logic:** Java
* **Database:** MySQL
* **Database Connectivity:** JDBC (Java Database Connectivity)

## ⚙️ Setup Instructions

Follow these steps to set up and run the project on your local machine.

### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **MySQL Server:** A running instance of MySQL.
* **MySQL JDBC Driver:** Download the appropriate connector JAR (e.g., `mysql-connector-java-x.x.xx.jar`).

### Database Setup

1.  **Create Database:**
    Open your MySQL client (e.g., MySQL Workbench, command line) and create a new database.

    ```sql
    CREATE DATABASE bankmanagementsystem;
    USE bankmanagementsystem;
    ```

2.  **Create Tables:**
    You will need to create the necessary tables for the `bankdb` database. Based on the project structure, at least `signup` and `signuptwo` tables are required. You might also need tables for `login` credentials, `bank` transactions, etc.

    Example `signup` table (assuming `formno` is a primary key that `signuptwo` references):

    ```sql
    CREATE TABLE signup (
    formno INT PRIMARY KEY,
    name VARCHAR(50),
    father_name VARCHAR(50),
    dob DATE,
    gender VARCHAR(10),
    email VARCHAR(50),
    marital_status VARCHAR(20),
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    pin VARCHAR(10)
    );
    ```

    Example `signuptwo` table (as discussed previously):

    ```sql
    CREATE TABLE signuptwo (
        formno INT PRIMARY KEY,
        religion VARCHAR(20) NOT NULL DEFAULT 'Not Specified',
        category VARCHAR(30) NOT NULL DEFAULT 'General',
        income VARCHAR(20) DEFAULT 'Unknown',
        education VARCHAR(30) DEFAULT 'Not Mentioned',
        occupation VARCHAR(30) DEFAULT 'Unemployed',
        pan VARCHAR(20) UNIQUE NOT NULL,
        aadhar VARCHAR(20) UNIQUE NOT NULL,
        senior_citizen VARCHAR(10) DEFAULT 'No',
        existing_account VARCHAR(10) DEFAULT 'No',
        FOREIGN KEY (formno) REFERENCES signup(formno) ON DELETE CASCADE
    );
    ```

    Example `signupthree` table:

    ```sql
    CREATE TABLE signupthree(
		card_number varchar(20) primary key not null,
        pin_number varchar(10) not null,
        account_type varchar(30) not null,
        formno int not null , 
        FOREIGN KEY (formno) REFERENCES signup(formno) ON DELETE CASCADE);
    ```

    Example `facility` table:

    ```sql
    CREATE TABLE facility (
		card_number varchar(20) primary key not null,
		atm_card boolean,
        internet_banking boolean,
        mobile boolean,
        email_alerts boolean,
        cheque boolean,
        E_statement boolean,
        FOREIGN KEY (card_number) REFERENCES signupthree(card_number) ON DELETE CASCADE);
    ```

    Example `Transaction` table:

    ```sql
    CREATE TABLE Transaction (
    card_number VARCHAR(20),
    pin_number VARCHAR(10),
    amount INT,
    type varchar(30),
    date DATETIME DEFAULT CURRENT_TIMESTAMP
    );
    ```

    Example `Balance` table:

    ```sql
    CREATE TABLE balance(
	card_number VARCHAR(20) PRIMARY KEY,
    bal int DEFAULT 0,
    FOREIGN KEY (card_number) REFERENCES signupthree(card_number) ON DELETE CASCADE);
    ```
    

    **Note:** Ensure your `Conn.java` file has the correct database URL, username, and password configured to connect to your MySQL instance.

### Project Setup (IDE - e.g., VS Code, Eclipse, IntelliJ IDEA)

1.  **Clone the Repository:**
    If this project is in a Git repository, clone it to your local machine.

2.  **Open in IDE:**
    Open the `Bank Management System` project folder in your preferred Java IDE.

3.  **Add JDBC Driver:**
    * Place the downloaded `mysql-connector-java-x.x.xx.jar` file into the `lib/` directory of the project.
    * In your IDE, add this JAR file to the project's build path (or module path). This step is crucial for the `Conn.java` class to establish a database connection.

4.  **Build Project:**
    Clean and build the project to compile all Java source files.

### Running the Application

1.  **Ensure MySQL Server is Running:** Verify that your MySQL server instance is active.
2.  **Run `Login.java`:** The application typically starts from the `Login.java` class, which contains the `main` method.
    * Right-click on `Login.java` in your IDE.
    * Select "Run" or "Run As Java Application."