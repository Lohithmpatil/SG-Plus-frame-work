package com.DowntimeModule; // Define the package for downtime module tests

// Import required TestNG and Selenium static assertions
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

// Import base class and utility classes
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeWorstMachineTest extends BaseClass {

	@Test
	public void DowntimeWorstMachineTest() throws Throwable {

		// Create instance of custom WebDriver utility class
		WebDriverUtility we = new WebDriverUtility();

		// Create object for HomePage POM (Page Object Model)
		HomePage hm = new HomePage(driver);

		// Create object for Downtime Dashboard POM
		DowntiemDashboard dt = new DowntiemDashboard(driver);

		// Wait until full page load is complete
		we.waitUntilPageLoad(driver);

		// Wait until all elements in the DOM are available
		we.waitForElementInDOM(driver);

		// Click on "Downtime" tab on homepage to open downtime module
		we.waitAndClick(hm.getDownTime());

		// Click on "Downtime Dashboard" from the downtime menu
		we.waitAndClick(hm.getDowntimeDashboard());

		// Click on filter button to open filter options
		we.waitAndClick(dt.getFilterButton());

		// Select "BU3" from Business Unit dropdown
		we.waitAndClick(dt.getBUDropDown());
		we.select(dt.getBUDropDown(), "BU3");

		// Select "TBM-PCR" from Area dropdown
		we.waitAndClick(dt.getAreaDropDown());
		we.select(dt.getAreaDropDown(), "TBM-PCR");

		// Select "Unistage" from Group dropdown
		we.waitAndClick(dt.getGroupDropDown());
		we.select(dt.getGroupDropDown(), "Unistage");

		// Click on Equipment dropdown to open equipment list
		we.waitAndClick(dt.getEquipementDropDown());

		// Select a specific equipment by clicking on its checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// Close the dropdown list
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Click on Period dropdown and select "Year"
		we.waitAndClick(dt.getPeriodDropDown());
		we.select(dt.getPeriodDropDown(), "Year");

		// Click on Shift dropdown and select "All"
		we.waitAndClick(dt.getShiftDropDown());
		we.select(dt.getShiftDropDown(), "All");

		// Click on Apply Filter button to load data
		we.waitAndClick(dt.getApplyFilter());

		// Scroll to the bottom of the page to make machine tables visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Click on tab/section to expand Best & Worst Performing Machines tables
		we.waitAndClick(dt.getBestPerfomingMachine());

		// ✅ VERIFY WORST PERFORMING MACHINES SECTION

		// Locate the heading text for Worst Performing Machines
		WebElement worstMachinesHeading = driver
				.findElement(By.xpath("//div[contains(text(),'WORST PERFORMING MACHINES')]"));

		// Assert that the heading is visible, meaning the section is present
		assertTrue(worstMachinesHeading.isDisplayed(), "Worst Performing Machines heading not visible");

		// Get list of rows from the Worst Performing Machines table
		List<WebElement> worstRows = driver.findElements(
				By.xpath("//div[contains(text(),'WORST PERFORMING MACHINES')]/following::table[1]/tbody/tr"));

		// Assert that at least one row of machine data is displayed
		assertTrue(worstRows.size() > 0, "No worst performing machines found");

	}
}