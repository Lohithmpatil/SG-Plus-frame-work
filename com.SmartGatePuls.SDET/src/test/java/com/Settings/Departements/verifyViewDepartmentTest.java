package com.Settings.Departements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.Departments;
import com.sgplus.erp.pomRepository.HomePage;

public class verifyViewDepartmentTest extends BaseClass {

	// TestNG test method annotation
	@Test
	public void verifyViewDepartmentTest() throws Throwable {

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

		we.waitAndClick(dp.getEdit3Dots());

		we.waitAndClick(dp.getViewbutton());

		WebElement viewHeader = driver.findElement(By.xpath("//h5[text()=\"view\"]"));

		Assert.assertTrue(viewHeader.getText().contains("View"));

		we.waitAndClick(dp.getCancelButton());
	}
}
