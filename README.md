# 📚 Core Java: Library Logistics Engine
**A lightweight, dependency-free backend management system.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![CLI](https://img.shields.io/badge/CLI-Terminal-4D4D4D?style=for-the-badge)

This is a fully functional Library Management System architected entirely in pure Java (JDK 8+). It was built specifically without external frameworks or databases to deeply explore core Object-Oriented Programming (OOP) principles, custom data persistence, and algorithmic search structures.

---

## 🚀 Core Architecture & Features

* **Custom Data Persistence:** Utilizes robust File I/O operations (`FileWriter`, `Scanner`) to maintain persistent state across sessions without a database.
* **Automated Transaction Logging:** Dynamically generates formatted `.txt` receipt files for all issue and return events.
* **State Management:** Tracks complex inventory states (Available, Issued, Overdue) using multi-dimensional array structures and exception handling.
* **Date & Time Logistics:** Leverages `java.time.LocalDate` for automated fine calculation and due-date tracking.

## 🧠 Technical Implementation

- **Object-Oriented Design:** Modular architecture separating core logic (`LibraryFunctions.java`) from storage management (`FileManager.java`).
- **Search & Sort Algorithms:** Custom implementations for querying inventory by ID, Title, or Author.
- **Error Handling:** Graceful exception catching for file corruption or invalid CLI inputs.

## 🖥️ Execution Guide

### Prerequisites
- Java JDK 8 or higher

### Initialization
1. Clone the repository:
   ```bash
   git clone [https://github.com/RudraS-Chauhan/Library-Management-System.git](https://github.com/RudraS-Chauhan/Library-Management-System.git)
