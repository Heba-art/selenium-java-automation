# Selenium Automation Project – SauceDemo

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat-square&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6F00?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![Pattern: POM](https://img.shields.io/badge/Pattern-Page%20Object%20Model-1E90FF?style=flat-square)
![Platform](https://img.shields.io/badge/Platform-SauceDemo-FF4500?style=flat-square)
![Status](https://img.shields.io/badge/Status-In%20Progress-lightgrey?style=flat-square)
![Report: Allure](https://img.shields.io/badge/Report-Allure-FF69B4?style=flat-square)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square)


![Profile Views](https://komarev.com/ghpvc/?username=heba-art&color=blue)
![GitHub Repo stars](https://img.shields.io/github/stars/heba-art/selenium-java-automation?style=social)
![GitHub forks](https://img.shields.io/github/forks/heba-art/selenium-java-automation?style=social)


This repository is part of my continuous learning journey as a QA Automation Engineer. It demonstrates a scalable and maintainable test automation framework using the Page Object Model (POM) design pattern.

## ✅ Test Coverage & Features

This framework includes a comprehensive suite of tests covering the main user flows of the SauceDemo application. The current test suite covers **10+ scenarios**, including:

-   **Login Functionality:**
    -   Successful login with valid credentials.
    -   Failed login with an invalid password.
    -   Verifying the error message for locked-out users.
    -   Ensuring logged-out users cannot access protected pages (e.g., inventory).

-   **Product & Inventory:**
    -   Verifying product details on the product page.
    -   Sorting products by price (e.g., Low to High).

-   **Shopping Cart & Checkout:**
    -   Adding an item to the shopping cart.
    -   Verifying that the cart state persists after logging out and back in.
    -   Validating the checkout process with missing user information (negative test).
    -   Completing the end-to-end checkout flow successfully.

## 🛠️ Tech Stack & Tools

-   **Core Language:** **Java**
-   **Browser Automation:** **Selenium WebDriver**
-   **Test Runner:** **TestNG**
-   **Build & Dependency Management:** **Maven**
-   **Design Pattern:** **Page Object Model (POM)**

## 📂 Project Structure
```bash
s- selenium-automation-project/
│
├── src/
│   ├── main/java/
│   │   └── com/mycompany/selenium_automation_project/
│   │       ├── CartPage.java
│   │       ├── CheckoutPage.java
│   │       ├── LoginPage.java
│   │       ├── ProductDetailsPage.java
│   │       └── ProductsPage.java
│   │
│   └── test/java/
│       └── com/mycompany/selenium_automation_project/
│           ├── base/
│           │   └── BaseTest.java
│           │
│           ├── tests/
│           │   ├── SauceDemoAddToCartTest.java
│           │   ├── SauceDemoCartPersistenceTest.java
│           │   ├── SauceDemoCheckoutNegativeTest.java
│           │   ├── SauceDemoCheckoutTest.java
│           │   ├── SauceDemoCheckoutTotalsTest.java
│           │   ├── SauceDemoLoginInvalidTest.java
│           │   ├── SauceDemoLoginLockedOutTest.java
│           │   ├── SauceDemoLoginValidTest.java
│           │   ├── SauceDemoLogoutProtectionTest.java
│           │   ├── SauceDemoProductDetailsTest.java
│           │   ├── SauceDemoSortByNameAToZTest.java
│           │   └── SauceDemoSortTest.java
│           │
│           └── util/
│               └── TestListener.java
│
├── allure-results/                 # Allure test result files (JSON, screenshots, etc.)
├── target/
│   ├── allure-report/              # Generated Allure HTML reports
│   ├── surefire-reports/           # Default TestNG reports
│   └── ...
│
├── pom.xml                         # Maven project configuration
├── testng.xml                      # TestNG suite configuration
├── README.md                       # Project documentation
└── TestCases.md                    # Test cases summary
```

## ▶️ How to Run Tests

1.  **Prerequisites:**
    -   Java Development Kit (JDK) installed.
    -   Apache Maven installed.
    -   A web browser (e.g., Chrome) installed.

2.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Heba-art/selenium-automation-project.git](https://github.com/Heba-art/selenium-automation-project.git)
    cd selenium-automation-project
    ```

3.  **Install dependencies:**
    ```bash
    mvn clean install
    ```

4.  **Execute the tests:**
    ```bash
    mvn test
    ```

## 🗺️ Roadmap & Future Enhancements

The following features are planned for future development to enhance the framework's capabilities:

-   [ ] **Reporting:** Integrate **Allure Reports** for detailed test execution results with screenshots on failure.
-   [ ] **Cross-Browser Testing:** Configure the framework to run tests across Chrome, Firefox, and Edge.
-   [ ] **Parallel Execution:** Implement parallel test execution using TestNG to reduce run time.
-   [ ] **CI/CD Integration:** Set up a continuous integration pipeline using **GitHub Actions** or **Jenkins**.

## 📊 Allure Reports

### Generate Report Locally
```bash
mvn clean test
allure generate target/allure-results -o target/allure-report --clean
allure open target/allure-report

```
## 🔗 Connect with Me

This project is a key part of my growth as a **Test Automation Engineer**. Follow my progress and connect with me!

-   💼 **LinkedIn:** [linkedin.com/in/heba-al-rubaye-21180021b](https://www.linkedin.com/in/heba-al-rubaye-21180021b)
-   📂 **GitHub:** [github.com/Heba-art](https://github.com/Heba-art)

The project follows a standard Maven structure, separating page objects, test cases, and supporting files for maintainability.