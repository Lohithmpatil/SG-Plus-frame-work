package com.ReasonLinkingPage;  // Package for Reason Linking related tests

// Import Selenium and TestNG classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Import project-specific base classes and utilities
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class ReasonLinkingFilterDataValidationTest extends BaseClass {  // Test class extends BaseClass for setup/teardown

	@Test
	public void ReasonLinkingFilterDataValidationTest() throws InterruptedException {

		// Create instance of WebDriverUtility to use custom wait and select methods
		WebDriverUtility we = new WebDriverUtility();

		// Initialize HomePage Page Object Model to interact with homepage UI elements
		HomePage hm = new HomePage(driver);

		// Initialize ReasonLinking POM to interact with Reason Linking page elements
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		// Click on the Downtime menu item on the homepage
		we.waitAndClick(hm.getDownTime());

		// Click on the Reason Linking submenu option
		we.waitAndClick(rs.getReasonLinking());

		// Click on the Business Unit (BU) dropdown to open it
		we.waitAndClick(rs.getBUDropDown());

		// Select "BU3" from the BU dropdown options
		we.select(rs.getBUDropDown(), "BU3");

		// Click to open the Equipment dropdown list
		we.waitAndClick(rs.getEquipmentDropDown());

		// Select the checkbox for the desired equipment
		we.waitAndClick(rs.getEquipmentCheckbox());

		// Click on the From Date field to activate the date picker
		we.waitAndClick(rs.getFromDate());

		// Wait until the From Date input element is ready for interaction
		we.waitForElement(driver, rs.getFromDate());

		// Clear any pre-filled date in the From Date input field
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

		// Enter the From Date as "14-01-2025"
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");

		// Click to open the Link dropdown filter
		we.waitAndClick(rs.getLinkDropDown());

		// Select the "Unlinked" option from the Link dropdown
		we.select(rs.getLinkDropDown(), "Unlinked");

		// Click the Search button to apply all selected filters and load data
		we.waitAndClick(rs.getSearchButton());

		// Locate the data table with id "expanded-table" on the page
		WebElement table = driver.findElement(By.id("expanded-table"));

		// Check if the table is displayed and print appropriate message
		if (table.isDisplayed()) {
			System.out.println("Table is visible on the page");
		} else {
			System.out.println("Table is not visible");
		}

	}

}