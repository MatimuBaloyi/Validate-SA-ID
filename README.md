Validate South African ID – Java TDD Project
This project validates South African ID numbers based on a specific 13-digit format. Built using Java and tested with JUnit, it follows a Test-Driven Development (TDD) approach from start to finish.

🧾 ID Format: YYMMDDSSSSCAZ
Each South African ID number is 13 digits long, formatted as follows:

| Section | Meaning                                              | Example    |
| ------- | ---------------------------------------------------- | ---------- |
| YYMMDD  | Date of Birth (e.g. 920220)                          | 1992-02-20 |
| SSSS    | Gender (0000–4999 = Female, 5000–9999 = Male)        | 5800       |
| C       | Citizenship (0 = SA Citizen, 1 = Permanent Resident) | 0          |
| A       | Usually 8 (not validated)                            | 8          |
| Z       | Checksum (Luhn Algorithm)                            | 6          |


✅ Features
📏 Validates input length and numeric characters only

📅 Checks valid months (01–12) and days (01–31)

🚻 Validates gender digits and maps to gender

🇿🇦 Validates citizenship status

🔢 Verifies final digit using the Luhn checksum algorithm

✅ Returns true for valid IDs, false for invalid ones

🧪 Unit Tests
Built using JUnit 5, the test suite includes:

Valid ID examples

Invalid length (too short/long)

Non-numeric characters

Invalid month/day

Invalid citizenship

Invalid checksum

Run tests via:
./gradlew test


📁 Project Structure

Validate-SA-ID/
├── app/
│   ├── src/
│   │   ├── main/java/org/example/ValidateSaId.java
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

Run tests using:
./gradlew test

🙋‍♀️ Author
Matimu Baloyi
A passionate developer building practical, test-driven Java applications.

