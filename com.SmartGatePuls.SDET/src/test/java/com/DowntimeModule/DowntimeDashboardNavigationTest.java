package com.DowntimeModule; // Define the package for downtime module tests

// Import required Selenium and TestNG libraries
import org.openqa.selenium.By;
import org.testng.annotations.Test;

// Import base and utility classes
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeDashboardNavigationTest extends BaseClass {

	@Test
	public void DowntimeDashboardNavigationTest() throws Throwable {

		// Create object of WebDriverUtility for custom Selenium helper methods
		WebDriverUtility we = new WebDriverUtility();

		// Initialize Page Object Model for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize Page Object Model for Downtime Dashboard Page
		DowntiemDashboard dt = new DowntiemDashboard(driver);

		// Wait for the full page to load
		we.waitUntilPageLoad(driver);

		// Ensure DOM elements are completely loaded
		we.waitForElementInDOM(driver);

		// Click on the "Downtime" section in the homepage navigation
		we.waitAndClick(hm.getDownTime());

		// Click on the "Downtime Dashboard" option from the Downtime menu
		we.waitAndClick(hm.getDowntimeDashboard());

		// Click on the "Filter" button to expand filter options
		we.waitAndClick(dt.getFilterButton());

		// Click on Business Unit (BU) dropdown
		we.waitAndClick(dt.getBUDropDown());

		// Select "BU3" from the BU dropdown
		we.select(dt.getBUDropDown(), "BU3");

		// Click on Area dropdown
		we.waitAndClick(dt.getAreaDropDown());

		// Select "TBM-PCR" area
		we.select(dt.getAreaDropDown(), "TBM-PCR");

		// Click on Group dropdown
		we.waitAndClick(dt.getGroupDropDown());

		// Select "Unistage" group
		we.select(dt.getGroupDropDown(), "Unistage");

		// Click on Equipment dropdown to view equipment list
		we.waitAndClick(dt.getEquipementDropDown());

		// Select the first equipment by clicking the checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// Close the dropdown after selecting equipment
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Click on Period dropdown
		we.waitAndClick(dt.getPeriodDropDown());

		// Select "Year" from Period dropdown
		we.select(dt.getPeriodDropDown(), "Year");

		// Click on Shift dropdown
		we.waitAndClick(dt.getShiftDropDown());

		// Select "All" shifts from Shift dropdown
		we.select(dt.getShiftDropDown(), "All");

		// Click on "Apply Filter" button to load the dashboard data
		we.waitAndClick(dt.getApplyFilter());

		// ------------------------------------------------------------
		// 🟩 VALIDATE THAT THE USER HAS NAVIGATED TO CORRECT PAGE
		// ------------------------------------------------------------

		// Define the expected URL of the Downtime Dashboard
		String expectedURL = "http://sgp.smartiotsystem.com/dashboard/downtime";

		// Get the actual current URL from the browser
		String actualURL = driver.getCurrentUrl();

		// Compare expected and actual URLs to validate navigation
		if (expectedURL.equals(actualURL)) {
			System.out.println("✅ Navigation to Downtime Dashboard was successful.");
		} else {
			System.out.println("❌ Navigation failed. Current URL: " + actualURL);
		}
	}
}