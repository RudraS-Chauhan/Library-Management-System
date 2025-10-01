# 📚 Java Library Management System

A command-line based Library Management System developed in Java. This project was created as part of foundational learning in Object-Oriented Programming and Java file handling — aligned with the ICSE Class 12 Computer Science curriculum.

---

## 🔧 Features

- 📘 Add and manage books
- 👨‍🎓 Issue books to students with due dates
- 🔄 Return books with fine calculation for late returns
- 📄 Generate transaction receipts (issued/returned)
- 🔍 Search for books by ID, title, or author
- 📊 View issued books by all, borrower, or overdue only
- 📝 Export issued books report
- 💾 Persistent storage via text files

---

## 🗂️ Project Structure

LibraryManagement/
├── src/
│ ├── Main.java # Application entry point
│ ├── LibraryFunctions.java # Core library functionalities
│ └── FileManager.java # Handles saving and loading of data
├── books.txt # Data file to store book records
├── receipts/ # Folder for generated receipts
├── issued_report_TIMESTAMP.txt # Generated reports
├── .gitignore
└── README.md



---

## 🚀 Getting Started

### ✅ Prerequisites

- Java Development Kit (JDK 8 or later)
- Command-line terminal or IDE (like IntelliJ, Eclipse)

### ▶️ How to Compile and Run

```bash
cd src
javac *.java
java Main
