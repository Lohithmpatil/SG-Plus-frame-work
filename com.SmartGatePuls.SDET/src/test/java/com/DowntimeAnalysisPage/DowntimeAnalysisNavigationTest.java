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

public class DowntimeAnalysisNavigationTest extends BaseClass {

	// Test method to verify navigation and basic validations on the Downtime
	// Analysis page
	@Test
	public void Reasonlinkingpage() throws InterruptedException {

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
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// Close the dropdown by clicking on the arrow icon
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Click on "Apply Filter" to load the filtered data/chart
		we.waitAndClick(da.getApplyFilter());

		// Locate the bar chart container (replace selector with actual chart element selector)
		WebElement barChart = driver.findElement(By.cssSelector("canvas, svg, or specific bar element"));

		// Validate that the bar chart is visible
		Assert.assertTrue(barChart.isDisplayed(), "Bar chart is not visible.");

		// Validate that the chart legend contains the text "Target"
		Assert.assertTrue(driver.getPageSource().contains("Target"));

		// Validate that the chart legend contains the text "Actual"
		Assert.assertTrue(driver.getPageSource().contains("Actual"));
	}
}