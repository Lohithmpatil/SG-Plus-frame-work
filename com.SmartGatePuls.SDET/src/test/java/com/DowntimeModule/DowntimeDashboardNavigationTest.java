package com.DowntimeModule; // Define the package for downtime module tests

// Import required Selenium and TestNG libraries
import org.openqa.selenium.By;
import org.testng.annotations.Test;

// Import base and utility classes
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeDashboardPage;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeDashboardNavigationTest extends BaseClass {

	@Test
	public void DowntimeDashboardNavigationTest() throws Throwable {

		// Create object of WebDriverUtility for custom Selenium helper methods
		WebDriverUtility we = new WebDriverUtility();

		// Initialize Page Object Model for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize Page Object Model for Downtime Dashboard Page
		DowntimeDashboardPage dt = new DowntimeDashboardPage(driver);

		// Wait until the page is fully loaded
		we.waitUntilPageLoad(driver);

		// Wait until all elements are loaded in the DOM
		we.waitForElementInDOM(driver);

		// Click on Down Time module from home page
		we.waitAndClick(hm.getDownTime());

		// Click on Downtime Dashboard option
		we.waitAndClick(hm.getDowntimeDashboard());

		// Click on filter button
		we.waitAndClick(dt.getFilterButton());

		// Click on BU dropdown
		we.waitAndClick(dt.getBUDropDown());

		// Select BU3 checkbox
		we.waitAndClick(dt.getBu3checkbox());

		// Collapse BU dropdown
		we.waitAndClick(dt.getCollpaseBUdropdown());

		// Click on Area dropdown
		we.waitAndClick(dt.getAreaDropDown());

		// Select Area checkbox (TBM-PCR)
		we.waitAndClick(dt.getAreaCheckox());

		// Collapse Area dropdown
		we.waitAndClick(dt.getCollpaseAreadropdown());

		// Click on Group dropdown
		we.waitAndClick(dt.getGroupDropDown());

		// Select Group checkbox (Unistage)
		we.waitAndClick(dt.getGroupCheckbox());

		// Collapse Group dropdown
		we.waitAndClick(dt.getCollpaseGroupdropdown());

		// Click on Equipment dropdown
		we.waitAndClick(dt.getEquipementDropDown());

		// Select Equipment checkbox
		we.waitAndClick(dt.getEquipementCheckbox());

		// Collapse Equipment dropdown
		we.waitAndClick(dt.getCollpaseEquipementsdropdown());

		// Click on Period dropdown
		we.waitAndClick(dt.getPeriodDropDown());

		// Select "Range" option from Period dropdown
		we.select(dt.getPeriodDropDown(), "Range");

		// Click on From Date input field
		we.waitAndClick(dt.getFromdateSelection());

		// Enter From Date value
		dt.getFromdateSelection().sendKeys("01-01-2025");

		// Click on To Date input field
		we.waitAndClick(dt.getTodateSelection());

		// Enter To Date value
		dt.getTodateSelection().sendKeys("30-01-2025");

		// Click on Shift dropdown
		we.waitAndClick(dt.getShiftDropDown());

		// Select "All" from Shift dropdown
		we.select(dt.getShiftDropDown(), "All");

		// Click on Apply Filter button
		we.waitAndClick(dt.getApplyFilter());

		// ------------------------------------------------------------
		// 🟩 VALIDATE THAT THE USER HAS NAVIGATED TO CORRECT PAGE
		// ------------------------------------------------------------

		// Define the expected URL of the Downtime Dashboard
		String expectedURL = "http://192.168.5.77:3000/dashboard/downtime";

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