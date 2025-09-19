package com.ReasonLinkingPage;  // Package declaration for Reason Linking related tests

// Import necessary Selenium, TestNG, and project-specific utility classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class ReasonLinkingCycleTimeSourceFilterTest extends BaseClass {  // Test class extending BaseClass to reuse setup/teardown

	@Test
	public void ReasonLinkingCycleTimeSourceFilterTest() throws InterruptedException {

		// Instantiate WebDriverUtility to use custom wait and select methods
		WebDriverUtility we = new WebDriverUtility();

		// Instantiate HomePage POM to interact with home page UI elements
		HomePage hm = new HomePage(driver);

		// Instantiate ReasonLinking POM for elements specific to Reason Linking page
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		// Click on "Downtime" menu tab from homepage
		we.waitAndClick(hm.getDownTime());

		// Click on "Reason Linking" submenu
		we.waitAndClick(rs.getReasonLinking());

		// Click to open Business Unit dropdown
		we.waitAndClick(rs.getBUDropDown());

		// Select "BU3" option from BU dropdown
		we.select(rs.getBUDropDown(), "BU3");

		// Click to open Equipment dropdown
		we.waitAndClick(rs.getEquipmentDropDown());

		// Select equipment checkbox to choose equipment for filtering
		we.waitAndClick(rs.getEquipmentCheckbox());

		// Click on From Date picker field
		we.waitAndClick(rs.getFromDate());

		// Wait until From Date field is fully loaded and interactable
		we.waitForElement(driver, rs.getFromDate());

		// Clear any pre-filled value in From Date input box
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

		// Enter From Date value as "01-01-2025"
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

		// Click on To Date picker field
		we.waitAndClick(rs.getToDate());

		// Clear any pre-filled value in To Date input box
		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).clear();

		// Enter To Date value as "02-01-2025"
		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).sendKeys("02-01-2025");

		// Click to open Source dropdown filter
		we.waitAndClick(rs.getSourceDropDown());

		// Select the 3rd option (index 2) from the Source dropdown (likely "Cycle Time")
		we.select(rs.getSourceDropDown(), 2);

		// Click to open Link filter dropdown
		we.waitAndClick(rs.getLinkDropDown());

		// Select "All" from Link dropdown to include all linked/unlinked data
		we.select(rs.getLinkDropDown(), "All");

		// Click the Search button to apply all selected filters
		we.waitAndClick(rs.getSearchButton());

		// Click on the element representing data in the Cycle Time Source column to ensure visibility
		we.waitAndClick(rs.getCycleTimeSourceData());

		// Verify that the Cycle Time data in Source column is displayed on the page
		boolean found = rs.getCycleTimeSourceData().isDisplayed();

		// Assert that Cycle Time data is present, else fail with message
		Assert.assertTrue(found, "CycleTime not displayed in Source column!");

	}

}