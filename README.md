Tic-Tac-Toe — Android App (Java)

A simple and clean Tic-Tac-Toe game built in Android Studio (Java + XML).
This is my first Android app project, where users can play X vs O with a smooth UI, animations, and auto-restart after winning.

⭐ Features

✔ Two-player X vs O mode. O are predefinedly present on the grid.

✔ Click animations for each move

✔ Win detection for all 8 possible combinations

✔ Automatic game reset after win

✔ Clean UI with custom grid background

✔ Status indicator showing whose turn it is

✔ Built entirely using ConstraintLayout + LinearLayout

📱 Screenshots

Example:
<img width="475" height="730" alt="image" src="https://github.com/user-attachments/assets/d983b613-7d9d-4228-a34e-e41400415951" />
<img width="446" height="744" alt="image" src="https://github.com/user-attachments/assets/f9ebe26a-7d14-4ea2-a4ff-14c665e1aa37" />



🧠 Game Logic Overview

gameState array tracks board positions

activePlayer switches between 0 (X) and 1 (O)

winPositions contains all winning patterns

When a cell is tapped:

If empty → mark X/O

Animate the symbol

Check for win

If won → show message & wait for next tap to reset

🗂️ Project Structure
app/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/rishik/tictactoe/MainActivity.java
 │   │   ├── res/
 │   │   │   ├── drawable/
 │   │   │   ├── layout/activity_main.xml
 │   │   │   └── values/
 │   │   └── AndroidManifest.xml
 ├── build.gradle.kts

🛠️ Tech Stack

Language: Java

UI: XML Layouts

IDE: Android Studio

Build System: Gradle (KTS)

🚀 How to Run Locally

Clone the repository:

git clone https://github.com/your-username/tic-tac-toe-android.git


Open the project in Android Studio

Let Gradle sync

Run on Emulator or Physical Device

📄 License

This project is licensed under the MIT License — feel free to modify it.

💬 Feedback & Suggestions

This is my first Android project — feedback and improvements are always welcome!
