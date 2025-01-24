# Automated Testing Project

This project contains a suite of automated tests designed for end-to-end testing of a web application. The framework is built with **Java**, utilizes **Maven** for dependency management, **Selenium** for browser automation, and **JUnit 5** for test execution. Additionally, the project is fully Dockerized, enabling easy and consistent test execution across environments.

## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Tests](#running-the-tests)
  - [Using Maven](#using-maven)
  - [Using Docker](#using-docker)
- [Test Structure](#test-structure)
- [Test Reports](#test-reports)
- [Troubleshooting](#troubleshooting)

---

## Project Overview

This project automates the testing of core functionalities for a web application, such as:

- **User Authentication:** Login/logout with valid and invalid credentials.
- **Navigation:** Validation of menus, navigation bars, and page transitions.
- **Form Interactions:** Filling out and submitting forms.
- **Feature Verification:** Ensuring key functionalities work as intended.

**System Under Test (SUT):** The application under test is hosted at `https://www.saucedemo.com/`.

---

## Tech Stack

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
- ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
- ![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
- ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
- ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

---

## Prerequisites

Before running the tests, ensure the following are installed:

1. **Java Development Kit (JDK)** (version 11 or later)
2. **Maven** (version 3.6.0 or later)
3. **WebDriver** (e.g., ChromeDriver) – Ensure the WebDriver version matches your browser version.

**Optional:**

- **Docker:** Required if running tests in a containerized environment.
- **Integrated Development Environment (IDE):** IntelliJ IDEA or Eclipse for viewing or modifying test code.

---

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/CodecoolGlobal/test-automation-webshop-in-beta-general-qutasi.git
   cd test-automation-webshop-in-beta-general-qutasi
   
2. **Build and run the tests using Docker Compose**
   ```bash
   docker-compose up --build
   
---

## Running the Tests

### Using Maven

To execute all tests:

```bash
mvn clean test
```

To run specific test classes or methods:

```bash
mvn -Dtest=TestClassName#methodName test
```

### Using Docker

```bash
docker-compose up 
```

The Docker container will automatically set up the environment, execute the tests, and save reports to `/target` inside the container.

---

## Test Structure

The project follows the Page Object Model (POM) design pattern:

- **Pages:** Located in `src/test/java/com/codecool/models`
  - Contains reusable components representing application pages.
- **Tests:** Located in `src/test/java/com/codecool/test`
  - Includes test cases for verifying application functionality.

---

## Test Reports

After executing the tests, reports will be available in the following directory:

```
/target/surefire-reports/
```

These reports provide detailed information about passed, failed, or skipped tests.

---

## Troubleshooting

- Ensure the WebDriver version matches your browser version.
- If using Docker, verify that Docker is installed and running.
- Check for missing dependencies or errors in the Maven build logs.
- Update WebDriver or browser versions if compatibility issues arise.
