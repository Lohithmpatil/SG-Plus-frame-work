package com.Settings.DepartmentGroup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DepartmentGroup;
import com.sgplus.erp.pomRepository.HomePage;

public class verifySearchDepartmentGroupTest extends BaseClass {
	// TestNG test method to verify Add Department Group functionality
	@Test
	public void verifySearchDepartmentGroupTest() throws Throwable {

		// Create WebDriverUtility object for custom wait and click operations
		WebDriverUtility we = new WebDriverUtility();

		// Create JavaUtility object to generate random numbers
		JavaUtility jlib = new JavaUtility();

		// Create FileUtility object to read data from property files (if needed)
		FileUtility flib = new FileUtility();

		// Create ExcelUtility object to read test data from Excel sheet
		ExcelUtility elib = new ExcelUtility();

		// Create HomePage object to interact with home page elements
		HomePage hm = new HomePage(driver);

		// Create DepartmentGroup page object to interact with Department Group screen
		DepartmentGroup dg = new DepartmentGroup(driver);

		// Generate a random number to make department group name unique
		int intRanNum = jlib.getRandomNumber();

		// Read base group name from Excel and append random number
		String Groupname = elib.getDataFromExcel("Sheet1", 1, 0) + intRanNum;

		// Wait until DOM elements are loaded
		we.waitForElementInDOM(driver);

		// Wait until the page is completely loaded
		we.waitUntilPageLoad(driver);

		// Click on Settings menu from home page
		we.waitAndClick(hm.getSettings());

		// Click on Department Group option under Settings
		we.waitAndClick(dg.getGroup());

		// we.waitAndClick(dg.getSearchfield());

		// Locate search field
		WebElement searchField = dg.getSearchfield();

		// Enter search text
		// searchField.clear();
		searchField.clear();
		searchField.sendKeys("Automation859");
		searchField.sendKeys(Keys.ENTER);

		// Wait for table to update
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Automation859']")));

		// Fetch table result
		WebElement resultName = driver.findElement(By.xpath("//td[text()='Automation859']"));

		// Validation
		Assert.assertEquals(resultName.getText(), "Automation859");

	}
}
