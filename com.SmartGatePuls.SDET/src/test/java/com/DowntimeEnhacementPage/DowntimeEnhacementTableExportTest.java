// Declares the package name where this class is located
package com.DowntimeEnhacementPage;

// Imports Selenium By class (used for locating elements)
import org.openqa.selenium.By;

// Imports TestNG Test annotation
import org.testng.annotations.Test;

// Imports BaseClass which contains common setup (driver, login, etc.)
import com.sgplus.erp.genericutility.BaseClass;

// Imports WebDriverUtility which contains reusable Selenium methods
import com.sgplus.erp.genericutility.WebDriverUtility;

// Imports Page Object Model class for Downtime Enhancement page
import com.sgplus.erp.pomRepository.DowntimeEnhacement;

// Imports Page Object Model class for Home page
import com.sgplus.erp.pomRepository.HomePage;

// Class declaration which extends BaseClass to inherit WebDriver and setup
public class DowntimeEnhacementTableExportTest extends BaseClass {

	// TestNG annotation to mark this method as a test case
	@Test
	public void DowntimeEnhacementTableExport() throws Throwable {

		// Creating object of WebDriverUtility to use utility methods
		WebDriverUtility we = new WebDriverUtility();

		// Creating HomePage object to access Home page elements
		HomePage hm = new HomePage(driver);

		// Creating DowntimeEnhacement object to access Downtime Enhancement page elements
		DowntimeEnhacement de = new DowntimeEnhacement(driver);

		// Waits until DownTime button is clickable and then clicks it
		we.waitAndClick(hm.getDownTime());

		// Waits until Enhancement Module button is clickable and then clicks it
		we.waitAndClick(de.getEnhacementModule());

		// Waits until Filter button is clickable and then clicks it
		we.waitAndClick(de.getFilterButton());

		// Waits until Business Unit dropdown is clickable and clicks it
		we.waitAndClick(de.getBUDropDown());

		// Selects BU3 checkbox from Business Unit dropdown
		we.waitAndClick(de.getBu3checkbox());

		// Collapses the Business Unit dropdown
		we.waitAndClick(de.getCollpaseBUdropdown());

		// Opens Area dropdown
		we.waitAndClick(de.getAreaDropDown());

		// Selects Area checkbox
		we.waitAndClick(de.getAreaCheckox());

		// Collapses Area dropdown
		we.waitAndClick(de.getCollpaseAreadropdown());

		// Opens Group dropdown
		we.waitAndClick(de.getGroupDropDown());

		// Selects Group checkbox
		we.waitAndClick(de.getGroupCheckbox());

		// Collapses Group dropdown
		we.waitAndClick(de.getCollpaseGroupdropdown());

		// Opens Equipment dropdown
		we.waitAndClick(de.getEquipementDropDown());

		// Selects Equipment checkbox
		we.waitAndClick(de.getEquipementCheckbox());

		// Collapses Equipment dropdown
		we.waitAndClick(de.getCollpaseEquipementsdropdown());

		// Clicks on From Date field
		we.waitAndClick(de.getFromdateSelection());

		// Clears existing value in From Date field
		de.getFromdateSelection().clear();

		// Enters From Date value
		de.getFromdateSelection().sendKeys("01-01-2025");

		// Clicks on To Date field
		we.waitAndClick(de.getTodateSelection());

		// Clears existing value in To Date field
		de.getTodateSelection().clear();

		// Enters To Date value
		de.getTodateSelection().sendKeys("30-01-2025");

		// Clicks on Apply Filter button
		we.waitAndClick(de.getApplyFilter());

		// Waits until the table is clickable (ensures data is loaded)
		we.waitAndClick(de.getTable());

		// Waits until Export button is clickable and clicks it to export data
		we.waitAndClick(de.getExportButtton());
	}
}
