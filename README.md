# ✅ Validate South African ID – Java TDD Project

This project validates South African ID numbers based on a specific 13-digit format. Built using **Java**, tested with **JUnit**, and now includes a **user-friendly GUI** built with **Swing**. It follows a **Test-Driven Development (TDD)** approach from start to finish.

---

## 🧾 ID Format: `YYMMDDSSSSCAZ`

Each South African ID number is 13 digits long, formatted as follows:

| Digits   | Section       | Description                                           | Example  |
|----------|---------------|-------------------------------------------------------|----------|
| 1–6      | `YYMMDD`       | Date of Birth (Year, Month, Day)                     | 920220   |
| 7–10     | `SSSS`         | Sequence Number (determines gender)                  | 5800     |
| 11       | `C`            | Citizenship (0 = SA Citizen, 1 = Permanent Resident) | 0        |
| 12       | `A`            | Usually 8 (not officially used for validation)       | 8        |
| 13       | `Z`            | Checksum (Luhn Algorithm result)                     | 6        |

---

## ✅ Features

- 📏 Validates input length and numeric characters only  
- 📅 Checks valid months (01–12) and days (01–31)  
- 🚻 Extracts and displays **gender** (Male or Female)  
- 🇿🇦 Validates citizenship status  
- 🔢 Verifies the final digit using the **Luhn checksum** algorithm  
- 🖥️ **Swing GUI**: Allows users to validate IDs visually with a simple interface  
- ✅ Returns `true` for valid IDs, `false` for invalid ones  

--- 

## 🧪 Unit Tests

Built using **JUnit 5**, the test suite includes:

- ✅ Valid ID examples  
- ❌ Invalid length (too short/long)  
- ❌ Non-numeric characters  
- ❌ Invalid month/day  
- ❌ Invalid citizenship  
- ❌ Invalid checksum  

📦 Run tests using:

./gradlew test

📁 Project Structure

Validate-SA-ID/
├── app/
│   ├── src/
│   │   ├── main/java/org/example/ValidateSaId.java
│   │   ├── main/java/org/example/ValidateSaIdGUI.java
│   │   └── test/java/org/example/ValidateSaIdTest.java
├── build.gradle
├── settings.gradle
└── README.md
🛠️ Requirements
Java 11 or newer

Gradle 8+

JUnit 5

🚀 How to Run
Clone this repository

Open terminal and navigate to the project folder

Run the GUI:
./gradlew build
java -cp app/build/classes/java/main org.example.ValidateSaIdGUI

Run tests:
./gradlew test

🙋‍♀️ Author
Matimu Baloyi
A passionate developer building practical, test-driven Java applications.

📝 License
This project is licensed under the MIT License.