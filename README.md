This repository demonstrates a personal project aimed at gaining experience as an Automation Tester. As a fresher, the goal of this project is to build hands-on experience in automating website testing using **Selenium WebDriver**, **Java 21**, **TestNG**, and **Maven**. The framework automates basic interactions with a website (e.g., clicking links, buttons) to validate expected behavior.

## Features

- **Cross-Browser Support**: Chrome, Firefox, and Edge.
- **Test Reports**: Detailed HTML reports via **ExtentReports**.
- **Page Object Model (POM)**: Ensures better code maintainability and reusability.
- **Screenshot Capture**: Automatically captures screenshots on test failure.
- **Explicit Waits**: Handles synchronization for dynamic elements.
- **TestNG Listeners**: Detailed reporting and test lifecycle management.
- **Dynamic Browser Initialization**: Browser initialization based on configuration.

## Prerequisites

To run this automation framework, ensure you have the following installed:

- **Java 21** (or later)
- **Maven** for dependency management
- **Selenium WebDriver** for browser automation
- **TestNG** for test execution
- **ExtentReports** for reporting
- **WebDriverManager** for automatic browser driver management
- **Browser Drivers**: ChromeDriver, GeckoDriver, or EdgeDriver
- **IDE**: Any IDE that supports Maven (e.g., Eclipse, IntelliJ)

## Project Flow

The automation framework performs basic functionality tests by interacting with UI elements (e.g., buttons, links). Here’s the overall flow:

1. **Open Website**: Launch the homepage in the browser.
2. **Perform Interactions**: Simulate user actions such as clicking links and buttons.
3. **Switch Frames/Windows**: Handle switching between windows or frames for testing.
4. **Validate Actions**: Verify expected behavior (e.g., selecting a course, hovering over buttons).
5. **Generate Reports**: Create an HTML report using **ExtentReports**.

## Skills Demonstrated

This project showcases the following key skills for a fresher automation tester:

### Selenium WebDriver:
- Automated browser interactions (clicking links, buttons, selecting items).
- Validated expected behavior by simulating user actions.

### TestNG Framework:
- Created and executed tests using **TestNG** annotations like `@Test`, `@BeforeMethod`, etc.
- Configured tests to run in parallel or sequentially, grouped by functionality.

### Cross-Browser Testing:
- Configured the framework to run tests across multiple browsers (Chrome, Firefox, Edge).
- Ensured consistent behavior across different browser environments.

### Synchronization:
- Used **Explicit Waits** to handle dynamic elements and ensure proper synchronization.
- Waited for elements to be visible or clickable before interacting with them.

### Page Object Model (POM):
- Applied **POM** to structure test code, making it reusable and easier to maintain.
- Each page is represented by a class that encapsulates elements and actions.

### Test Reporting:
- Generated detailed HTML reports using **ExtentReports** to track test execution.
- Captured screenshots for failed tests to aid debugging.

### Version Control:
- Used **Git** for version control to track project changes and collaborate.

---

This project serves as a personal learning initiative, aiming to demonstrate and build the core skills necessary for an **Automation Tester**. It showcases how to automate web application testing, structure test cases, and create reusable code while gaining hands-on experience with **Selenium WebDriver**, **TestNG**, and **Maven**.
