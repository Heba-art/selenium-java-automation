# Selenium Automation Project – SauceDemo

# 🧪 Selenium Java Automation | TestNG | Allure | CI/CD

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-007396?style=flat&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Framework-TestNG-orange?style=flat&logo=testng&logoColor=white"/>
  <img src="https://img.shields.io/badge/Build-Maven-C71A36?style=flat&logo=apachemaven&logoColor=white"/>
  <img src="https://img.shields.io/badge/Pattern-Page%20Object%20Model-blue?style=flat"/>
  <img src="https://img.shields.io/badge/Site-SauceDemo-ff6c00?style=flat&logo=saucelabs&logoColor=white"/>
  <img src="https://img.shields.io/badge/Status-Passing-brightgreen?style=flat"/>
  <img src="https://img.shields.io/badge/Report-Allure-ff69b4?style=flat&logo=allure&logoColor=white"/>
  <a href="https://heba-art.github.io/selenium-java-automation/">
    <img src="https://img.shields.io/badge/Allure%20Report-Live-success?style=flat&logo=githubactions&logoColor=white"/>
  </a>
</p>


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

├── target/
│   ├── allure-report/              # Generated Allure HTML reports
│   ├── surefire-reports/           # Default TestNG reports
│   └── allure-results/             # Allure test result files (JSON, screenshots, etc.)
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
### Quick Preview
```bash
allure serve target/allure-results
```
### 💡Tip
You can also use the ready script:

```bash
run_allure.bat
```
This script automatically:

runs your TestNG tests

preserves Allure history for trend graphs

opens the report in your browser
## 🔗 Connect with Me

This project is a key part of my growth as a **Test Automation Engineer**. Follow my progress and connect with me!

-   💼 **LinkedIn:** [linkedin.com/in/heba-al-rubaye-21180021b](https://www.linkedin.com/in/heba-al-rubaye-21180021b)
-   📂 **GitHub:** [github.com/Heba-art](https://github.com/Heba-art)

The project follows a standard Maven structure, separating page objects, test cases, and supporting files for maintainability.