# 📚 Java Library Management System  
*A complete console-based library solution using only Class 12 ICSE-level Java*

---

## 📌 Overview

This project is a fully functional **Library Management System** written in **pure Java (JDK 8+)**, designed and developed based on **Class 12 ICSE Computer Applications** knowledge — no external libraries or frameworks used. It is an ideal example of how core Java can be used to build real-world applications with file handling, arrays, classes, and basic OOP principles.

---

## 💡 Features

✔️ Add new books to the library  
✔️ Issue books to students with auto due date  
✔️ Return books and handle overdue fines  
✔️ View available books (with sorting and summaries)  
✔️ Track issued books (all / by borrower / overdue only)  
✔️ Search books by ID, title, or author  
✔️ Auto-generate receipt text files for issue and return  
✔️ Export issued report to file  
✔️ Persistent storage using `books.txt`  
✔️ Clean and user-friendly CLI menu  
✔️ No external dependencies (only core Java)

---

## 🧠 Concepts Used

- Object-Oriented Programming (Classes & Objects)  
- Arrays (2D Arrays for Book and Issued Book Storage)  
- File Handling (`File`, `FileWriter`, `Scanner`)  
- Exception Handling  
- String Manipulation  
- Date Handling with `java.time.LocalDate`  
- Sorting and Searching Logic  
- Modular Design (Separate classes for logic and file management)

---

## 🖥️ How to Run

### Prerequisites:
- Java JDK 8 or above installed
- Any IDE (Eclipse / IntelliJ / BlueJ / VS Code) or terminal with `javac`

### Steps:

1. Clone this repository or download the `.zip`
2. Open the project in your IDE, or compile via terminal:
   ```bash
   javac Main.java
   java Main


LibraryManagementSystem/
├── Main.java                # Entry point
├── LibraryFunctions.java   # Core logic and features
├── FileManager.java        # Handles saving and loading from files
├── books.txt               # Auto-generated data file
├── receipts/               # Auto-generated receipts for transactions
└── README.md               # This file


 📷 Sample Output
=== LIBRARY MANAGEMENT MENU ===
1. Add Book
2. View All Books
3. Issue Book
4. Return Book
5. Search Book by Title/Author/ID
6. Show Issued Books
7. Export Issued Report
8. Sort Books by Title
9. Exit
Enter choice: _

📜 Sample Receipt (Generated Automatically)
=========================================
           LIBRARY TRANSACTION SLIP      
=========================================

Action      : ISSUED
Book ID     : BK101
Title       : Java for Beginners
Author      : John Doe
Student     : Rahul Sharma
Date        : 2025-10-02
Due Date    : 2025-10-16

=========================================
   Thank you for using the library!      
=========================================


⭐ Star this Project ⭐

---

Let me know if you'd like help:

- Replacing placeholders (your name, email, GitHub link, etc.)
- Generating screenshots or demo `.gif`s
- Creating a `.jar` file or ZIP for easy download
- Writing Fiverr/Gumroad copy for selling this project

Would you like me to add a **short documentation PDF** template for offline submission too?
