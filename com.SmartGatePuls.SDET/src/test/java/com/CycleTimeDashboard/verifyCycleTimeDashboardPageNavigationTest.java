package com.CycleTimeDashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
// Import TestNG @Test annotation
import org.testng.annotations.Test;

// Import BaseClass for common test setup and teardown
import com.sgplus.erp.genericutility.BaseClass;

// Import WebDriver utility methods
import com.sgplus.erp.genericutility.WebDriverUtility;

// Import Page Object Model class for Cycle Time Dashboard page
import com.sgplus.erp.pomRepository.CylceTimeDashboard;

// Import Page Object Model class for Home Page
import com.sgplus.erp.pomRepository.HomePage;

// Test class extending BaseClass to use WebDriver initialization
public class verifyCycleTimeDashboardPageNavigationTest extends BaseClass {

	// Test method to verify Cycle Time Dashboard page navigation
	@Test
	public void verifyCycleTimeDashboardNavigationTest() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		// Create CycleTimeDashboard object to access dashboard elements
		CylceTimeDashboard cd = new CylceTimeDashboard(driver);

		// Click on Cycle Time module from home page
		we.waitAndClick(hm.getCyletime());

		// Click on Cycle Time Dashboard menu
		we.waitAndClick(cd.getCycleTimedashboard());

		// Click on Filter button to open filter options
		we.waitAndClick(cd.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click it
		we.waitAndClick(cd.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(cd.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(cd.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown

		we.select(cd.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it

		we.waitAndClick(cd.getGroupDropDown());

		// Select "Unistage" from the Group dropdown

		we.select(cd.getGroupDropDown(), "Unistage");

		// Commented out code: Wait and select an Equipment dropdown option (not being
		// used)

		we.waitAndClick(cd.getEquipementDropDown());

		// Selects Equipment checkbox
		we.waitAndClick(cd.getEquipementCheckbox());

		// Collapses Equipment dropdown
		we.waitAndClick(cd.getCollpaseEquipementsdropdown());

		// Click on Period dropdown
		we.waitAndClick(cd.getPeriodDropDown());

		// Select "Range" option from Period dropdown
		we.select(cd.getPeriodDropDown(), "Range");

		// Clicks on From Date field
		we.waitAndClick(cd.getFromdateSelection());

		// Clears existing value in From Date field
		cd.getFromdateSelection().clear();

		// Enters From Date value
		cd.getFromdateSelection().sendKeys("01-01-2025");

		// Clicks on To Date field
		we.waitAndClick(cd.getTodateSelection());

		// Clears existing value in To Date field
		cd.getTodateSelection().clear();

		// Enters To Date value
		cd.getTodateSelection().sendKeys("30-01-2025");

		// Click on Apply Filter button to load data
		we.waitAndClick(cd.getApplyFilter());
		
		 // ===== Validate Page Header =====

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement cycleTimeHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id=\"title\"]//span[text()=\"Cycle Time\"]")));

        Assert.assertTrue(cycleTimeHeader.isDisplayed(),
                "Cycle Time header is not displayed");

	}
}
/*
 * @Test public void verifyCycleTimeDashboardPageNavigation() { }
 * 
 * @Test public void verifyCycleTimeDataTable() { }
 * 
 * @Test public void verifyUnitDropdownFunctionality() { }
 * 
 * @Test public void verifyRecipeDropdownFunctionality() { }
 * 
 * @Test public void verifyXAxisDropdownFunctionality() { }
 * 
 * @Test public void verifyExportFunctionality() { }
 */