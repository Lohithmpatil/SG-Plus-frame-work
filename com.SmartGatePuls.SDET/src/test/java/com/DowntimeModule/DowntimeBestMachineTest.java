package com.DowntimeModule;

// Static imports for assertions
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

// Base class and utility imports
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeBestMachineTest extends BaseClass {

	@Test
	public void Dashboard() throws Throwable {

		// Initialize WebDriver utility for custom waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize POM class for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize POM class for Downtime Dashboard page
		DowntiemDashboard dt = new DowntiemDashboard(driver);

		// Wait for the page and DOM to fully load
		we.waitUntilPageLoad(driver);
		we.waitForElementInDOM(driver);

		// Navigate to "Down Time" module via the homepage
		we.waitAndClick(hm.getDownTime());

		// Click on the "Downtime Dashboard" link in the menu
		we.waitAndClick(hm.getDowntimeDashboard());

		// Click the "Filter" button to open filter options
		we.waitAndClick(dt.getFilterButton());

		// Open BU (Business Unit) dropdown
		we.waitAndClick(dt.getBUDropDown());

		// Select "BU3" from BU dropdown
		we.select(dt.getBUDropDown(), "BU3");

		// Open Area dropdown
		we.waitAndClick(dt.getAreaDropDown());

		// Select "TBM-PCR" from Area dropdown
		we.select(dt.getAreaDropDown(), "TBM-PCR");

		// Open Group dropdown
		we.waitAndClick(dt.getGroupDropDown());

		// Select "Unistage" group from dropdown
		we.select(dt.getGroupDropDown(), "Unistage");

		// Open Equipment dropdown
		we.waitAndClick(dt.getEquipementDropDown());

		// Select a checkbox from equipment list (selects one equipment)
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// Close the equipment dropdown
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Open Period dropdown
		we.waitAndClick(dt.getPeriodDropDown());

		// Select "Year" from Period dropdown
		we.select(dt.getPeriodDropDown(), "Year");

		// Open Shift dropdown
		we.waitAndClick(dt.getShiftDropDown());

		// Select "All" shifts
		we.select(dt.getShiftDropDown(), "All");

		// Click on Apply Filter button to load dashboard data
		we.waitAndClick(dt.getApplyFilter());

		// Scroll to the bottom of the page to bring performance tables into view
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Click to open the "Best Performing Machines" section
		we.waitAndClick(dt.getBestPerfomingMachine());

		// Fetch rows from the Best Performing Machines table
		List<WebElement> bestRows = driver.findElements(
				By.xpath("//div[contains(text(),'BEST PERFORMING MACHINES')]/following::table[1]/tbody/tr"));

		// Assert that at least one machine is listed
		assertTrue(bestRows.size() > 0, "No best performing machines found");

		// Iterate over each row in the table
		for (WebElement row : bestRows) {
			// Get all <td> elements (columns) in the current row
			List<WebElement> cols = row.findElements(By.tagName("td"));

			// Extract machine name from first column
			String machineName = cols.get(0).getText().trim();

			// Extract downtime value from second column
			String downtime = cols.get(1).getText().trim();

			// Assert that the machine name is not empty
			assertFalse(machineName.isEmpty(), "Machine name is empty");

			// Assert that downtime value is in expected format (e.g., "23.5 mins")
			assertTrue(downtime.matches("\\d+(\\.\\d+)? mins"), "Invalid downtime format: " + downtime);
		}
	}
}