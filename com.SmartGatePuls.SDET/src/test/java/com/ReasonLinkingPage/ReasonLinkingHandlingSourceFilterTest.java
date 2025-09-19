package com.ReasonLinkingPage;  // Package for Reason Linking related tests

// Import required Selenium and TestNG classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// Import project-specific base classes and utilities
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class ReasonLinkingHandlingSourceFilterTest extends BaseClass {  // Test class extends BaseClass for setup and teardown

	@Test
	public void ReasonLinkingHandlingSourceFilterTest () throws InterruptedException {

		// Create an instance of WebDriverUtility to use its reusable methods like wait and select
		WebDriverUtility we = new WebDriverUtility();

		// Initialize HomePage Page Object Model to interact with homepage elements
		HomePage hm = new HomePage(driver);

		// Initialize ReasonLinking Page Object Model to interact with Reason Linking page elements
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		// Click on the Downtime section from homepage menu
		we.waitAndClick(hm.getDownTime());

		// Click on the Reason Linking submenu under Downtime
		we.waitAndClick(rs.getReasonLinking());

		// Click on the Business Unit dropdown to open it
		we.waitAndClick(rs.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(rs.getBUDropDown(), "BU3");

		// Click on the Equipment dropdown to open the equipment list
		we.waitAndClick(rs.getEquipmentDropDown());

		// Click on the equipment checkbox to select an equipment item
		we.waitAndClick(rs.getEquipmentCheckbox());

		// Click on the From Date field to activate the date picker/input
		we.waitAndClick(rs.getFromDate());

		// Wait until the From Date input element is ready and interactable
		we.waitForElement(driver, rs.getFromDate());

		// Clear any existing value from the From Date input box
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

		// Enter the date "01-01-2025" in the From Date field
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

		// Click on the To Date field to activate it
		we.waitAndClick(rs.getToDate());

		// Clear the existing value from the To Date input field
		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).clear();

		// Enter the date "02-01-2025" in the To Date field
		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).sendKeys("02-01-2025");

		// Click on the Source dropdown to open it
		we.waitAndClick(rs.getSourceDropDown());

		// Select the source option at index 1 from the dropdown list
		we.select(rs.getSourceDropDown(), 1);

		// Click on the Link dropdown to open it
		we.waitAndClick(rs.getLinkDropDown());

		// Select "All" from the Link dropdown options
		we.select(rs.getLinkDropDown(), "All");

		// Click the Search button to apply the filters and fetch results
		we.waitAndClick(rs.getSearchButton());

		// Click on the Handling Source Time data element to interact with or highlight it
		we.waitAndClick(rs.getHandlingSourceTimeData());

		// Check if the Handling Source Time data element is displayed on the page
		boolean found = rs.getHandlingSourceTimeData().isDisplayed();

		// Assert that Handling Time data is displayed; if not, test will fail with message
		Assert.assertTrue(found, "HandlingTime not displayed in Source column!");

	}

}