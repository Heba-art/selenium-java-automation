package com.mycompany.selenium_automation_project.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // === Chrome Options to block password manager + popups ===
        ChromeOptions options = new ChromeOptions();

        // 1) تعطيل مدير كلمات المرور نهائياً (يمنع ظهور Change your password)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // اختياري: إيقاف إشعارات المتصفح
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        // 2) تعطيل بعض الميزات المرتبطة بالـ Password Manager
        options.addArguments("--disable-features=PasswordImport,PasswordManagerOnboarding,PasswordManagerRedesign");

        // 3) تقليل أي infobars/notifications عامة (اختياري)
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        wait   = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
