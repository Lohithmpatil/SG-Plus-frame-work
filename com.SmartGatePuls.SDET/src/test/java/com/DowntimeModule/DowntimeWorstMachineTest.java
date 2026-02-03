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
import com.sgplus.erp.pomRepository.DowntimeDashboardPage;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeWorstMachineTest extends BaseClass {

	@Test
	public void DowntimeWorstMachineTest() throws Throwable {

		// Create instance of custom WebDriver utility class
		WebDriverUtility we = new WebDriverUtility();

		// Create object for HomePage POM (Page Object Model)
		HomePage hm = new HomePage(driver);

		// Create object for Downtime Dashboard POM
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