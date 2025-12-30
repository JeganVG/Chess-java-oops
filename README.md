# ♟️ Chess Game (Java OOP)

A modular, object-oriented implementation of a Chess game written in Java. This project was developed as a coding machine test to demonstrate proficiency in software design, OOP principles, and logical problem-solving.

## 📋 Project Overview

This application simulates a standard game of chess, enforcing the rules of movement for different pieces and managing the game state. It is designed with extensibility in mind, making it easy to add new features or integrate a graphical user interface (GUI) in the future.

### Key Features
* **Object-Oriented Design:** distinct classes for the Board, Pieces (King, Queen, Rook, etc.), and Game Logic.
* **Move Validation:** Checks for legal moves based on piece type and board boundaries.
* **Turn-Based Logic:** Manages player turns (White vs. Black).
* **Encapsulation:** Protects game state and logic within appropriate classes.

## 🛠️ Tech Stack

* **Language:** Java (JDK 8+)
* **Paradigm:** Object-Oriented Programming (OOP)
* **Interface:** Console / Command Line (CLI)

## 📂 Repository Structure

The main source code is located inside the `ChessCodingMachineTest` directory.

```bash
Chess-java-oops/
└── ChessCodingMachineTest/
    ├── src/               # Source files (presumed structure)
    │   ├── pieces/        # Classes for King, Queen, Pawn, etc.
    │   ├── board/         # Board and Cell management
    │   └── Main.java      # Entry point of the application
    └── ...
