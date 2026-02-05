package com.DowntimeAnalysisPage;

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

public class DowntimeAnalysisDropdownValidationTest extends BaseClass {

	// Test method to verify navigation and basic validations on the Downtime
	// Analysis page
	@Test
	public void DowntimeAnalysisDropdownValidationTest() throws Throwable {

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

		we.waitAndClick(da.getDepartmentGroupDropdown());
		we.select(da.getDepartmentGroupDropdown(), "Engineering");

		// we.waitAndClick(da.getDepartmentDropdown());

		// we.select(da.getDepartmentDropdown(), "Electrical");

		we.waitAndClick(da.getGoButton());
		// Locate the bar chart container (replace selector with actual chart element
		// selector)
		WebElement barChart = driver.findElement(By.cssSelector("canvas, svg, or specific bar element"));

		// Validate that the bar chart is visible
		Assert.assertTrue(barChart.isDisplayed(), "Bar chart is not visible.");

		// Validate that the chart legend contains the text "Target"
		Assert.assertTrue(driver.getPageSource().contains("Target"));

		// Validate that the chart legend contains the text "Actual"
		Assert.assertTrue(driver.getPageSource().contains("Actual"));
	}
}