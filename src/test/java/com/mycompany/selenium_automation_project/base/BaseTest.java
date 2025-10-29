package com.mycompany.selenium_automation_project.base;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class BaseTest {
	protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        // 1. Setup WebDriverManager to automatically download the correct chromedriver
        WebDriverManager.chromedriver().setup();
        
        // 2. Configure Chrome Options
        ChromeOptions options = new ChromeOptions();

        // --- Configure preferences to disable annoying popups (like "Save Password") ---
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);              // Stop password service
        prefs.put("profile.password_manager_enabled", false);        // Stop saving passwords
        prefs.put("profile.password_manager_leak_detection", false); // Stop leak warnings
        prefs.put("autofill.profile_enabled", false);                // stop Autofill profiles
        prefs.put("autofill.credit_card_enabled", false);            // stop Autofill credit cards
        options.setExperimentalOption("prefs", prefs);

        // --- GitHub Actions (CI/CD) specific settings ---
        options.addArguments("--headless=new"); // ✅ Always run Chrome in headless mode on GitHub Actions
        options.addArguments("--no-sandbox"); // ✅ Prevent common GitHub container issues
        options.addArguments("--disable-dev-shm-usage"); // ✅ Prevent common GitHub container issues

        // --- General stability and consistency settings ---
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1920,1080");

        // --- Create a unique temporary user data directory each run ---
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());
        
        // (Note: The second, redundant 'prefs' block was removed)

        // 3. Create a WebDriver with options only (once!)
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies(); // Start with a clean slate

        // 4. Define the Base URL for the application
        baseUrl = "https://www.saucedemo.com/"; // <-- This was the missing line

        // 5. Initialize WebDriverWait with the DEFAULT_TIMEOUT
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        // This method runs after every @Test
        if (driver != null) {
            try {
                // Check if the test failed
                if (result.getStatus() == ITestResult.FAILURE) {
                    // Attach screenshot and URL to Allure report
                    attachScreenshot("❌ Failure Screenshot");
                    Allure.addAttachment("URL at Failure", driver.getCurrentUrl());
                }
            } finally {
                // Always quit the driver to close the browser session
                driver.quit();
            }
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void writeAllureEnvironment() throws Exception {
        // This runs once before all tests to create the Allure environment file
        String dir = System.getProperty("allure.results.directory", "target/allure-results");
        Path resultsDir = Paths.get(dir);

        // Create the allure-results directory if it doesn't exist
        java.nio.file.Files.createDirectories(resultsDir);
        
        // Define properties for the Allure environment.properties file
        Properties p = new Properties();
        p.setProperty("Tester", "Heba AL-Rubaye");
        p.setProperty("Environment", "QA");
        p.setProperty("BaseURL", "https://www.saucedemo.com");
        p.setProperty("Browser", "Chrome"); // More maintainable than a specific version
        p.setProperty("Execution Mode", "Headless");
        p.setProperty("Build", "GitHub Actions CI");

        // Write the properties to the file
        File envFile = resultsDir.resolve("environment.properties").toFile();
        try (OutputStream out = new FileOutputStream(envFile)) {
            p.store(out, "Allure environment");
        }
    }

    /**
     * Attaches a screenshot to the Allure report.
     * @param name The name for the attachment.
     */
    private void attachScreenshot(String name) {
        byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(png));
    }

    /**
     * Getter for the WebDriver instance.
     * @return the WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Static block to set the Allure results directory property when the class is loaded.
     */
    static {
        System.setProperty("allure.results.directory", "target/allure-results");
    }

    /**
     * A robust click method that retries on failure.
     * It scrolls, waits for clickable, and uses a JS click fallback.
     * This method should ideally be in BasePage so Page Objects can use it.
     * @param locator The By locator of the element to click.
     */
}