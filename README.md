# 🚀 Selenium Java Automation Project  

This is a **Test Automation Framework** built with **Java, Selenium, TestNG, and Maven**.  
It follows the **Page Object Model (POM)** design pattern and integrates with **Allure Reports** for reporting.  

---

## 📂 Project Structure

selenium-java-automation
┣ src
┃ ┣ main/java # Page Objects, utilities, base classes
┃ ┗ test/java # Test cases using TestNG
┣ pom.xml # Maven dependencies
┣ testng.xml # TestNG suite configuration
┣ allure-results # Allure test execution results (auto-generated)
┗ target # Build output (auto-generated)

---

## 🛠️ Tools & Technologies
- **Java 11+**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Allure Reports**

---

### How to Run Tests

1. Clone this repository:  
   `git clone https://github.com/Heba-art/selenium-java-automation.git`

2. Navigate to project folder:  
   `cd selenium-java-automation`

3. Run tests with Maven:  
   `mvn clean test`

4. Generate Allure report:  
   `mvn allure:serve`



📌 Notes

Make sure Java 11+ and Maven are installed and configured in your system PATH.

Allure must be installed to view reports locally
   