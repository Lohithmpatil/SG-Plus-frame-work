// Package declaration – defines the folder structure for Department tests
package com.Settings.Departements;

// Import Duration class for explicit wait timeout
import java.time.Duration;

// Import Selenium classes for locating elements and interacting with UI
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Import Selenium wait utilities
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Import TestNG assertion and annotation
import org.testng.Assert;
import org.testng.annotations.Test;

// Import BaseClass which handles browser setup, login, and teardown
import com.sgplus.erp.genericutility.BaseClass;

// Import utility classes used across the framework
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;

// Import Page Object Model classes
import com.sgplus.erp.pomRepository.Departments;
import com.sgplus.erp.pomRepository.HomePage;

// Test class for verifying Add Department functionality
public class VerifyAddDepartmentTest extends BaseClass {

	// TestNG test method annotation
	@Test
	public void VerifyAddDepartmentTest() throws Throwable {

		// Create WebDriverUtility object for waits, clicks, dropdown handling
		WebDriverUtility we = new WebDriverUtility();

		// Create JavaUtility object to generate random numbers
		// Used to avoid duplicate department names
		JavaUtility jlib = new JavaUtility();

		// Create FileUtility object (used for property file reading if required)
		FileUtility flib = new FileUtility();

		// Create ExcelUtility object to read test data from Excel sheet
		ExcelUtility elib = new ExcelUtility();

		// Create HomePage POM object to access home page elements
		HomePage hm = new HomePage(driver);

		// Create Departments POM object to access department-related elements
		Departments dp = new Departments(driver);

		// Generate a random number to make the department name unique
		int intRanNum = jlib.getRandomNumber();

		// Read department base name from Excel (Sheet1, Row 2, Column 2)
		// Append random number to avoid duplication
		String Departmentname = elib.getDataFromExcel("Sheet1", 1, 1) + intRanNum;

		// Wait until all DOM elements are loaded
		we.waitForElementInDOM(driver);

		// Wait until the page is fully loaded
		we.waitUntilPageLoad(driver);

		// Click on the Settings menu from the Home page
		we.waitAndClick(hm.getSettings());

		// Click on the Departments option under Settings
		we.waitAndClick(dp.getDepartments());

		// Click on Add Departments button
		we.waitAndClick(dp.getAdddepartments());

		// Click on the Department Name input field
		we.waitAndClick(dp.getDepartmentNameField());

		// Enter the generated department name into the input field
		dp.getDepartmentNameField().sendKeys(Departmentname);

		// Click on the Department Group dropdown
		we.waitAndClick(dp.getGroupDropDown());

		// Select "Engineering" from the Department Group dropdown
		we.select(dp.getGroupDropDown(), "Engineering");

		// Click on the Equipment dropdown
		we.waitAndClick(dp.getEquipemetsDropDown());

		// Select an equipment checkbox from the dropdown
		we.waitAndClick(dp.getCheckBoxofEquipement());

		// Click on the arrow button to close the equipment dropdown
		we.waitAndClick(dp.getArrowButton());

		// Click on the Description text area
		we.waitAndClick(dp.getDiscriptionfield());

		// Enter description text for the department
		dp.getDiscriptionfield().sendKeys("Automaton Test for Add Departments Functionality");

		// Click on the Submit button to create the department
		we.waitAndClick(dp.getSubmitButton());

		// Create explicit wait to wait for success toast message
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until the success message is visible on the UI
		WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Department created successfully')]")));

		// Capture the actual success message text
		String actualMessage = toastMsg.getText();

		// Assert that the success message contains expected text
		Assert.assertTrue(actualMessage.contains("Department created successfully"),
				"Department creation success message is NOT displayed");

		// Print the success message in console for verification
		System.out.println("SUCCESS MESSAGE VERIFIED: " + actualMessage);
	}
}
