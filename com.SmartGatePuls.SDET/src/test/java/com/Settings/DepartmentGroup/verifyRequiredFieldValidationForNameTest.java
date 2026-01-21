package com.Settings.DepartmentGroup;

import java.time.Duration;

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

public class verifyRequiredFieldValidationForNameTest extends BaseClass {

	// TestNG test method to verify Add Department Group functionality
	@Test
	public void verifyRequiredFieldValidationForNameTest() throws Throwable {

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

		// Click on Add Department Group button
		we.waitAndClick(dg.getAddDepartmentGroup());

		// Click inside Department Group Name text box
		we.waitAndClick(dg.getGroupname());

		// Enter unique department group name
		dg.getGroupname().sendKeys(Groupname);

		// Select "Yes" radio button for MTTR MTBF Source
		we.waitAndClick(dg.getMTTRAandMTBFSorceButton());

		// Click on Add button to submit the form
		we.waitAndClick(dg.getAddButton());

		// Create explicit wait to wait for success toast message
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until success popup message becomes visible
		wait.until(ExpectedConditions.visibilityOf(dg.getSuccessToast()));

		// Capture the success popup message text
		String actualMsg = dg.getSuccessToast().getText();

		// Prepare expected success message using dynamic group name
		String expectedMsg = Groupname + " Department Group created successfully";

		// Verify actual popup message matches expected message
		Assert.assertEquals(actualMsg, expectedMsg);

		// Print the success message in console for reference
		System.out.println(actualMsg);

	}
}
