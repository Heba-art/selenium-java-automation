
package com.mycompany.selenium_automation_project;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By titleProducts = By.className("title");
    private final By errorBanner = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public void login(String user, String pass) {
    	driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isOnProductsPage() {
        return driver.findElement(titleProducts).getText().trim().equalsIgnoreCase("Products");
    }
    
    public String getErrorMesssage() {
    	return driver.findElement(errorBanner).getText().trim();
    		
    }
    public void waitUntilLoaded() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
    }
    public boolean isLoaded() {
    	try { return driver.findElement(username).isDisplayed()
    	&& driver.findElement(password).isDisplayed()
    	&& driver.findElement(loginBtn).isDisplayed()
    	&& !driver.getCurrentUrl().contains("/inventory.html");
    	}catch (NoSuchElementException e) {
            return false;
        }
    }
}
