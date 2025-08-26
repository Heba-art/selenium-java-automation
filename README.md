# Selenium Automation Project – SauceDemo

🚀 **Automated UI Testing with Java, Selenium, and TestNG**

This project is part of my QA Automation learning journey, showcasing how I design and build scalable test automation frameworks.  
It covers functional test cases for the [SauceDemo](https://www.saucedemo.com/) application.

---

## 📌 Overview
This project is a Selenium Test Automation framework built for **SauceDemo** site.  
It includes **login functionality tests** and **cart functionality tests**, following **Page Object Model (POM)** design.

---

## ✅ Work Done
- Implemented **Login tests**:
  - Valid login (success)
  - Invalid login (wrong password)
  - Locked out user
- Implemented **Cart test**:
  - Add single item to cart
  - Remove item from cart
- Created **TestCases.md** file:
  - Contains all test cases in table format
  - Includes steps, expected results, and actual results

---

## 🛠️ Tech Stack
- **Java**  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven**  
- **Allure Reports (planned)**  

## ▶️ How to Run
1. Clone the repo:
   ```bash
   git clone https://github.com/Heba-art/selenium-automation-project.git
   
---

---

## ✅ Current Coverage (10 Test Cases)
- **Login**
  - Valid login  
  - Invalid login  
  - Locked-out user  

- **Cart**
  - Add single item  
  - Remove item  

- **Checkout**
  - Complete checkout flow  

- **Products**
  - Sort products (low → high)  
  - Cart state persists after navigation  
  - Logout & access protection  

📌 *Target: 25–30 scenarios including sorting options, multi-item cart, reset app state, checkout validations, totals/tax, protected routes.*

---

## 🛠️ Tech Stack
- Java + Maven  
- Selenium WebDriver  
- TestNG  
- Page Object Model (POM)  

---

## 📊 Reporting & CI/CD (Planned)
- [ ] Allure Reports + Screenshots on failure  
- [ ] Cross-browser (Chrome/Edge/Firefox)  
- [ ] Parallel execution with TestNG  
- [ ] GitHub Actions / Jenkins integration  

---

## 🌟 My QA Journey
This repo is part of my continuous growth as a **Test Automation Engineer**.  
Follow my journey on LinkedIn 👉 #Heba_QAJourney

---

## 🔗 Connect
- 💼 LinkedIn: [www.linkedin.com/in/heba-al-rubaye-21180021b](#)  
- 📂 GitHub: [https://github.com/Heba-art](#)

## ▶️Project Structure 

```markdown
src
 ├── main/java
 │   └── com.mycompany.selenium_automation_project
 │         ├── LoginPage.java
 │         ├── ProductsPage.java
 │         └── CartPage.java
 ├── test/java
 │   └── com.mycompany.selenium_automation_project.tests
 │         ├── SauceDemoLoginValidTest.java
 │         ├── SauceDemoLoginInvalidTest.java
 │         ├── SauceDemoLoginLockedOutTest.java
 │         └── SauceDemoAddToCartTest.java
TestCases.md
README.md
pom.xml
testng.xml
---

