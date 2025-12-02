package com.DowntimeAnalysisPage;

import java.util.List;

// Importing necessary Selenium and TestNG classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// Importing base and utility classes
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;

// Importing Page Object Model (POM) classes
import com.sgplus.erp.pomRepository.DowntimeAnalysisPage;
import com.sgplus.erp.pomRepository.HomePage;

public class MonthWiseBarChartNavigationTest extends BaseClass {

	// Test method to verify navigation and basic validations on the Downtime
	// Analysis page
	@Test
	public void MonthWiseBarChartNavigationTest() throws InterruptedException {

		// Create utility object for custom WebDriver actions like waits and dropdowns
		WebDriverUtility we = new WebDriverUtility();

		// Initialize HomePage object to interact with home screen elements (menu, etc.)
		HomePage hm = new HomePage(driver);

		// Initialize DowntimeAnalysisPage object to interact with downtime page
		// elements
		DowntimeAnalysisPage da = new DowntimeAnalysisPage(driver);

		// Wait for and click the "Downtime" menu icon from the sidebar
		we.waitAndClick(hm.getDownTime());

		// Wait for and click the "Downtime Analysis" option under Downtime
		we.waitAndClick(da.getDowntimeAnalysis());

		// Click on the filter button to reveal filter options
		we.waitAndClick(da.getFilterButton());

		// Open Business Unit dropdown
		we.waitAndClick(da.getBUDropDown());

		// Select "BU3" from Business Unit dropdown
		we.select(da.getBUDropDown(), "BU3");

		// Open Area dropdown
		we.waitAndClick(da.getAreaDropDown());

		// Select "TBM-PCR" from Area dropdown
		we.select(da.getAreaDropDown(), "TBM-PCR");

		// Open Group dropdown
		we.waitAndClick(da.getGroupDropDown());

		// Select "All" from Group dropdown
		we.select(da.getGroupDropDown(), "All");

		// Open Equipment dropdown
		we.waitAndClick(da.getEquipementDropDown());

		// Click the first checkbox in the equipment list (select equipment)

		we.waitAndClick(da.getCheckBoxEquipements());

		// Close the dropdown by clicking on the arrow icon
		we.waitAndClick(da.getCheckBoxEquipementsSelect());

		// Click on "Apply Filter" button to load the chart based on selected filters
		we.waitAndClick(da.getApplyFilter());

		// Click on the month-wise bar chart (e.g., for April 2025) to expand it into a
		// day-wise view
		// This assumes that getMontwisebarchart() returns the WebElement for the bar
		// representing the month
		we.waitAndClick(da.getMontwisebarchart());

		// Find all day-wise bars displayed after expanding the month bar
		// This CSS selector matches the <rect> SVG element with an exact aria-label for
		// April 2025 and the value 1,218.84
		List<WebElement> dayBars = driver.findElements(By.cssSelector("[aria-label=\"2025-04, 1,218.84. Actual.\"]"));

		// Assert that one or more day-wise bars are present, indicating that the chart
		// successfully expanded
		Assert.assertTrue(dayBars.size() > 0, "Day-wise chart not expanded.");
	}
}