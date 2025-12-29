# 📘 Student Management System using Java File Handling

## 📌 Project Overview
The **Student Management System** is a console-based Java application that performs **CRUD operations (Create, Read, Update, Delete)** on student records using **Java File Handling**.  
Instead of using a database, all student data is stored persistently in a text file.

This project helps students understand **file-based data management** and real-world application logic without database dependency.

---

## 🎯 Objectives
- Implement CRUD operations using Java
- Understand Java File Handling concepts
- Use `BufferedReader` and `BufferedWriter`
- Store data permanently without a database
- Build a menu-driven console application

---

## 🛠️ Technologies Used
- Java (JDK 8 or above)
- Java File Handling
- BufferedReader & BufferedWriter
- FileReader & FileWriter
- Console-based application

---


Each record is stored on a new line.

---

## ⚙️ Features (CRUD Operations)

### ➕ Add Student
- Accepts Student ID, Name, and Age
- Stores data in the file

### 📄 View Students
- Reads and displays all student records

### ✏️ Update Student
- Updates name and age using Student ID
- Uses a temporary file

### ❌ Delete Student
- Deletes a student record using Student ID
- Keeps remaining records unchanged

### 🚪 Exit
- Safely exits the application

---

## ▶️ How to Run

### Compile
```bash
javac StudentManagementSystem.java
java StudentManagementSystem
