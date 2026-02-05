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

public class YearlyToMonthlyChartNavigationTest extends BaseClass {

	// Test method to verify navigation and basic validations on the Downtime
	// Analysis page
	@Test
	public void YearlyToMonthlyChartNavigationTest() throws Throwable{

		// Create utility object for custom WebDriver actions like waits asnd dropdowns
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

		// Waits until Filter button is clickable and then clicks it
		we.waitAndClick(da.getFilterButton());

		// Waits until Business Unit dropdown is clickable and clicks it
		we.waitAndClick(da.getBUDropDown());

		// Selects BU3 checkbox from Business Unit dropdown
		we.waitAndClick(da.getBu3checkbox());

		// Collapses the Business Unit dropdown
		we.waitAndClick(da.getCollpaseBUdropdown());

		// Opens Area dropdown
		we.waitAndClick(da.getAreaDropDown());

		// Selects Area checkbox
		we.waitAndClick(da.getAreaCheckox());

		// Collapses Area dropdown
		we.waitAndClick(da.getCollpaseAreadropdown());

		// Opens Group dropdown
		we.waitAndClick(da.getGroupDropDown());

		// Selects Group checkbox
		we.waitAndClick(da.getGroupCheckbox());

		// Collapses Group dropdown
		we.waitAndClick(da.getCollpaseGroupdropdown());

		// Opens Equipment dropdown
		we.waitAndClick(da.getEquipementDropDown());

		// Selects Equipment checkbox
		we.waitAndClick(da.getEquipementCheckbox());

		// Collapses Equipment dropdown
		we.waitAndClick(da.getCollpaseEquipementsdropdown());

		// Clicks on Apply Filter button
		we.waitAndClick(da.getApplyFilter());

		// Click on the month-wise bar chart (e.g., for April 2025) to expand it into a
		// day-wise view
		// This assumes that getMontwisebarchart() returns the WebElement for the bar
		// representing the month
		we.waitAndClick(da.getYearlywisebarchart());

		// Find all day-wise bars displayed after expanding the month bar
		// This CSS selector matches the <rect> SVG element with an exact aria-label for
		// April 2025 and the value 1,218.84
		List<WebElement> dayBars = driver.findElements(By.cssSelector("[aria-label=\"2024, 5,998.37. 2024.\"]"));

		// Assert that one or more year-wise bars are present, indicating that the chart
		// successfully expanded
		Assert.assertTrue(dayBars.size() > 0, "Year-wise chart not expanded.");
	}
}