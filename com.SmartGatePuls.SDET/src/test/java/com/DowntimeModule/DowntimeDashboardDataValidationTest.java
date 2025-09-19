package com.DowntimeModule;

// Import necessary Selenium and TestNG classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Import base classes and utilities
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeDashboardDataValidationTest extends BaseClass {

	@Test
	public void DowntimeDashboardDataValidationTest() throws InterruptedException {

		// Initialize WebDriver utility class for custom wait and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize Home Page POM
		HomePage hm = new HomePage(driver);

		// Initialize Downtime Dashboard POM
		DowntiemDashboard dt = new DowntiemDashboard(driver);

		// Wait until the full page is loaded
		we.waitUntilPageLoad(driver);

		// Wait until all DOM elements are ready
		we.waitForElementInDOM(driver);

		// Click on "Downtime" menu in the homepage
		we.waitAndClick(hm.getDownTime());

		// Click on "Downtime Dashboard" under the Downtime menu
		we.waitAndClick(hm.getDowntimeDashboard());

		// Click on "Filter" button to open filter options
		we.waitAndClick(dt.getFilterButton());

		// Click on "Business Unit" dropdown
		we.waitAndClick(dt.getBUDropDown());

		// Select BU3 from the dropdown
		we.select(dt.getBUDropDown(), "BU3");

		// Click on "Area" dropdown
		we.waitAndClick(dt.getAreaDropDown());

		// Select area "TBM-PCR"
		we.select(dt.getAreaDropDown(), "TBM-PCR");

		// Click on "Group" dropdown
		we.waitAndClick(dt.getGroupDropDown());

		// Select group "Unistage"
		we.select(dt.getGroupDropDown(), "Unistage");

		// Click on Equipment dropdown to open equipment list
		we.waitAndClick(dt.getEquipementDropDown());

		// Select first equipment by clicking on its checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// Close the equipment dropdown
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Click on "Period" dropdown
		we.waitAndClick(dt.getPeriodDropDown());

		// Select "Year" from period options
		we.select(dt.getPeriodDropDown(), "Year");

		// Click on "Shift" dropdown
		we.waitAndClick(dt.getShiftDropDown());

		// Select "All" shifts
		we.select(dt.getShiftDropDown(), "All");

		// Click on "Apply Filter" button to load filtered dashboard data
		we.waitAndClick(dt.getApplyFilter());

		// ------------------------------------------
		// ✅ Data Validations Start Here
		// ------------------------------------------

		// Validate that the correct page title is displayed
		String expectedTitle = "SmartGate+";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Correct page title: " + actualTitle);
		} else {
			System.out.println("Title mismatch. Expected: " + expectedTitle + ", Found: " + actualTitle);
		}

		// Check if Total Downtime value is visible on the dashboard
		WebElement totalDowntime = driver.findElement(
			By.xpath("//div[@class=\"align-self-center totalDowntime_totalDowntimeValue__1uE07\"]"));
		if (totalDowntime.isDisplayed()) {
			System.out.println("Total Downtime is displayed.");
		} else {
			System.out.println("Total Downtime is not displayed.");
		}

		// Check if MTTR (Mean Time to Repair) is visible
		WebElement mttr = driver.findElement(By.xpath("//div[contains(text(),'MTTR')]"));
		if (mttr.isDisplayed()) {
			System.out.println("MTTR is displayed.");
		} else {
			System.out.println("MTTR is not displayed.");
		}

		// Check if MTBF (Mean Time Between Failures) is visible
		WebElement mtbf = driver.findElement(By.xpath("//div[contains(text(),'MTBF')]"));
		if (mtbf.isDisplayed()) {
			System.out.println("MTBF is displayed.");
		} else {
			System.out.println("MTBF is not displayed.");
		}
	}
}