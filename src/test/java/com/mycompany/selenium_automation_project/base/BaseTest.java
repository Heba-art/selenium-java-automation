package com.mycompany.selenium_automation_project.base;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        // 1. Automatically download and setup the correct ChromeDriver
        WebDriverManager.chromedriver().setup();

        // 2. Configure Chrome options
        ChromeOptions options = new ChromeOptions();

        // --- Disable Chrome's built-in password and autofill popups ---
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // --- Settings for GitHub Actions or headless CI environments ---
        options.addArguments("--headless=new"); // Run Chrome in headless mode
        options.addArguments("--no-sandbox"); // Prevent sandbox errors in CI
        options.addArguments("--disable-dev-shm-usage"); // Avoid shared memory issues

        // --- General stability and consistency options ---
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1920,1080");

        // --- Create a temporary user data directory for each run ---
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());

        // 3. Create the WebDriver instance
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies(); // Ensure a clean browser session

        // 4. Define the base URL for the tests
        baseUrl = "https://www.saucedemo.com/";

        // 5. Create an explicit wait with a default timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ==============================================
    // 🧹 Tear Down (Runs After Each Test)
    // ==============================================
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        WebDriver d = driver;
        if (d == null) return;

        try {
            // Check if the WebDriver session is still active
            boolean sessionAlive = !(d instanceof RemoteWebDriver)
                    || ((RemoteWebDriver) d).getSessionId() != null;

            // Only take screenshots and attachments if the session is alive
            if (sessionAlive && result.getStatus() == ITestResult.FAILURE) {
                try {
                    attachScreenshot("❌ Failure Screenshot", d);
                } catch (WebDriverException ignored) {
                    System.out.println("⚠️ Unable to capture screenshot: " + ignored.getMessage());
                }

                try {
                    Allure.addAttachment("URL at Failure", d.getCurrentUrl());
                } catch (WebDriverException ignored) {
                    System.out.println("⚠️ Unable to capture current URL: " + ignored.getMessage());
                }
            }
        } finally {
            // Always attempt to close the browser gracefully
            try {
                d.quit();
            } catch (WebDriverException ignored) {
                System.out.println("⚠️ Browser already closed or session invalid.");
            }
            driver = null; // Avoid reusing a dead session
        }
    }

    // ==============================================
    // 📋 Environment Information for Allure
    // ==============================================
    @BeforeSuite(alwaysRun = true)
    public void writeAllureEnvironment() throws Exception {
        String dir = System.getProperty("allure.results.directory", "target/allure-results");
        Path resultsDir = Paths.get(dir);

        // Ensure the directory exists
        java.nio.file.Files.createDirectories(resultsDir);

        // Define Allure environment details
        Properties p = new Properties();
        p.setProperty("Tester", "Heba AL-Rubaye");
        p.setProperty("Environment", "QA");
        p.setProperty("BaseURL", "https://www.saucedemo.com");
        p.setProperty("Browser", "Chrome");
        p.setProperty("Execution Mode", "Headless");
        p.setProperty("Build", "GitHub Actions CI");

        // Write the environment.properties file
        try (OutputStream out = new FileOutputStream(resultsDir.resolve("environment.properties").toFile())) {
            p.store(out, "Allure environment");
        }
    }

    // ==============================================
    // 📸 Attach Screenshot to Allure Report
    // ==============================================
    @Attachment(value = "{name}", type = "image/png")
    private byte[] attachScreenshot(String name, WebDriver d) {
        try {
            return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            System.out.println("⚠️ Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    // ==============================================
    // 🚗 Get Driver Instance
    // ==============================================
    public WebDriver getDriver() {
        return driver;
    }

    // ==============================================
    // ⚙️ Static block for Allure path configuration
    // ==============================================
    static {
        System.setProperty("allure.results.directory", "target/allure-results");
    }
}
