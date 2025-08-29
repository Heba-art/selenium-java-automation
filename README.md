# Selenium Automation Project – SauceDemo

🚀 **An automated UI testing framework for the SauceDemo e-commerce website, built with Java, Selenium, and TestNG.**

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

s- **selenium-automation-project/**
  - **src/**
    - **main/java/**
      - **com/mycompany/selenium_automation_project/**
        - `CartPage.java`
        - `CheckoutPage.java`
        - `LoginPage.java`
        - `ProductDetailsPage.java`
        - `ProductsPage.java`
    - **test/java/**
      - **com/mycompany/selenium_automation_project/**
        - **base/**
          - `BaseTest.java`
        - **tests/**
          - `SauceDemoAddToCartTest.java`
          - `SauceDemoCartPersistenceTest.java`
          - `SauceDemoCheckoutNegativeTest.java`
          - `SauceDemoCheckoutTest.java`
          - `SauceDemoLoginInvalidTest.java`
          - `SauceDemoLoginLockedOutTest.java`
          - `SauceDemoLoginValidTest.java`
          - `SauceDemoLogoutProtectionTest.java`
          - `SauceDemoProductDetailsTest.java`
          - `SauceDemoSortTest.java`
  - `allure-results/`
  - `target/`
  - `pom.xml`
  - `README.md`
  - `TestCases.md`
  - `testng.xml`

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

## 🔗 Connect with Me

This project is a key part of my growth as a **Test Automation Engineer**. Follow my progress and connect with me!

-   💼 **LinkedIn:** [linkedin.com/in/heba-al-rubaye-21180021b](https://www.linkedin.com/in/heba-al-rubaye-21180021b)
-   📂 **GitHub:** [github.com/Heba-art](https://github.com/Heba-art)

The project follows a standard Maven structure, separating page objects, test cases, and supporting files for maintainability.