package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoSortByNameAToZTest extends BaseTest {

	@Test
	public void TC_SD_011_sortProductsByNameAToZ() throws InterruptedException {
	 // 1) Login
	 LoginPage login = new LoginPage(driver);
	 login.open(baseUrl);
	 login.login("standard_user", "secret_sauce");
	 
	 // 2) Open product details
	 ProductsPage products = new ProductsPage(driver);
	 products.waitUntilLoaded();
	 Thread.sleep(1000);
     products.sortByNameAToZ();
     Thread.sleep(1000);
     // Just check result
     Assert.assertTrue(products.isSortedByNameAToZ(),"Products are NOT sorted correctly by Name (A→Z).");
		
	}	
}
