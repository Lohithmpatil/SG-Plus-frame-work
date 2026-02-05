package com.DowntimeModule;

// Import necessary Selenium and TestNG classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Import base classes and utilities
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeDashboardPage;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeDashboardDataValidationTest extends BaseClass {

	@Test
	public void DowntimeDashboardDataValidationTest() throws Throwable {

		// Initialize WebDriver utility class for custom wait and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize Home Page POM
		HomePage hm = new HomePage(driver);

		// Initialize Downtime Dashboard POM
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
		WebElement totalDowntime = driver.findElement(By.xpath("//div[@class=\"align-self-center totalDowntime_totalDowntimeValue__hy1PE\"]"));
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