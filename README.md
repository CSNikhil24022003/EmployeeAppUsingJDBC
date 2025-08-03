🧾 Employee Management System (Java + JDBC)

A console-based **Employee Management Application** built using Java and JDBC, designed for managing employee records in a MySQL database. The system allows for CRUD operations, admin authentication, and file handling.

---

## 🚀 Features

- 🔐 Admin Login System
- 📥 Add New Employee
- 📄 View All Employees
- ✏️ Update Employee Data
- ❌ Delete Employee Record
- 📤 Export Employee Data to `.csv`
- 📥 Import Employee Data from `.txt` or `.csv`
- 📁 Clean file handling with report generation

---

## 🛠️ Tech Stack

| Tech        | Description                |
|-------------|----------------------------|
| Java        | Core programming language  |
| JDBC        | Database connectivity      |
| MySQL       | Backend relational database |
| File I/O    | Read/Write `.csv` & `.txt` |
| Eclipse IDE | Development Environment    |
| Git & GitHub| Version control            |

---

## 🧑‍💻 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/CSNikhil24022003/EmployeeAppUsingJDBC.git

2.Import the project into Eclipse (or any Java IDE).

3.Ensure MySQL is running and database/tables are created.

4.Update DB credentials in Db.java:

	String url = "jdbc:mysql://localhost:3306/empOperations";
	String user = "root";
	String password = "your_password";

5.Run App.java

-----------------------
📁 Project Structure
graphql
Copy
Edit
src/
└── myPack/
    ├── App.java              # Main class with menu & switch
    ├── Db.java               # DB connection class
    ├── Employee.java         # POJO model
    ├── EmpDAO.java           # All CRUD logic
    ├── Query.java            # SQL queries
input/
└── EmployeeInput.txt         # Optional input file for import
output/
└── EmployeeData.csv          # Exported employee report

-----------------------
📬 Author
Nikhil C S
📧 [Optional: csnikhil2003@gmail.com]
🔗 github.com/CSNikhil24022003

📜 License
This project is for educational purposes. Feel free to fork, clone, and improve.