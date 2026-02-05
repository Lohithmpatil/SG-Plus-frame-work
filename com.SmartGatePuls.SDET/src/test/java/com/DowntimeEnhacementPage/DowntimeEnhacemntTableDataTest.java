package com.DowntimeEnhacementPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeEnhacement;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeEnhacemntTableDataTest extends BaseClass {

	// The @Test annotation marks this method as a TestNG test case
	@Test
	public void DowntimeEnhacemntTableDataTest() throws Throwable {

		// Creating object of WebDriverUtility to use utility methods
		WebDriverUtility we = new WebDriverUtility();

		// Creating HomePage object to access Home page elements
		HomePage hm = new HomePage(driver);

		// Creating DowntimeEnhacement object to access Downtime Enhancement page
		// elements
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
		// Waits for and clicks the table to ensure it's loaded or interacts with the
		// table for further actions
		we.waitAndClick(de.getTable());

		WebElement table = de.getTable();
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Assert.assertTrue(rows.size() > 1, "Table has no rows or header row is missing.");

		// Verifying column count (example: 5 columns in total, including Machine, Total
		// Occ, Linked, Compliance)
		List<WebElement> headerColumns = table.findElements(By.xpath("//table//th"));
		Assert.assertTrue(headerColumns.size() > 5, "Column count mismatch in table");

	}
}