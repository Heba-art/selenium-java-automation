package com.mycompany.selenium_automation_project.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        baseUrl = "https://www.saucedemo.com/";
        
        // 1) إعداد الخيارات
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);              // إيقاف خدمة كلمات المرور
        prefs.put("profile.password_manager_enabled", false);        // إيقاف حفظ كلمات المرور
        prefs.put("profile.password_manager_leak_detection", false); // إيقاف تحذيرات التسريب
        prefs.put("autofill.profile_enabled", false);                // إيقاف Autofill
        prefs.put("autofill.credit_card_enabled", false);            // إيقاف Autofill الكروت
        options.setExperimentalOption("prefs", prefs);

        // 2) أعلام إضافية
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");         // اختياري
        options.addArguments("--start-maximized");

        // 3) إنشاء WebDriver مع الخيارات فقط (مرّة واحدة!)
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        // 4) WebDriverWait بالـ DEFAULT_TIMEOUT
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
