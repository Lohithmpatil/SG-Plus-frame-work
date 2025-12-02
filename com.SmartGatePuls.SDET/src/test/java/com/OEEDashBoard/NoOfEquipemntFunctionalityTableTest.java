package com.OEEDashBoard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class NoOfEquipemntFunctionalityTableTest extends BaseClass {

	@Test
	public void NoOfEquipemntFunctionalityTableTest() throws Throwable {

		// Initialize WebDriver utility for custom waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize POM class for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize POM class for Downtime Dashboard page
		OEEdashboard oe = new OEEdashboard(driver);

		// Wait for the page and DOM to fully load
		// we.waitUntilPageLoad(driver);
		// we.waitForElementInDOM(driver);

		// Navigate to "OEE " module via the homepage
		we.waitAndClick(hm.getOEE());

		// Click on the "oee Dashboard" link in the menu
		we.waitAndClick(oe.getOEEdashboard());

		// Click the "Filter" button to open filter options
		we.waitAndClick(oe.getFilterButton());

		// Open BU (Business Unit) dropdown
		we.waitAndClick(oe.getBUDropDown());

		// Select "BU3" from BU dropdown
		we.select(oe.getBUDropDown(), "BU3");

		// Open Area dropdown
		we.waitAndClick(oe.getAreaDropDown());

		// Select "TBM-PCR" from Area dropdown
		we.select(oe.getAreaDropDown(), "TBM-PCR");

		// Open Group dropdown
		we.waitAndClick(oe.getGroupDropDown());

		// Select "Unistage" group from dropdown
		we.select(oe.getGroupDropDown(), "Unistage");

		// Open Equipment dropdown
		we.waitAndClick(oe.getEquipementDropDown());

		// Select a checkbox from equipment list (selects one equipment)
		we.waitAndClick(oe.getEquipemntCheckBox());

		// Close the equipment dropdown
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Open Period dropdown
		we.waitAndClick(oe.getPeriodDropDown());

		// Select "Year" from Period dropdown
		we.select(oe.getPeriodDropDown(), "Year");

		// Open Shift dropdown
		we.waitAndClick(oe.getShiftDropDown());

		// Select "All" shifts
		we.select(oe.getShiftDropDown(), "All");

		// Click on Apply Filter button to load dashboard data
		we.waitAndClick(oe.getApplyFilter());

		// 1. Verify OEE Dashboard page navigation
		WebElement oeeNav = driver.findElement(By.xpath("//span[text()=\"OEE\"]"));

		Assert.assertTrue(oeeNav.isDisplayed());

		we.waitAndClick(oe.getNoOfEuipemntButton());
		// Locate the table
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'table-bordered')]"));

		// Get all rows from tbody
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Row count: " + rows.size());

		// Loop through each row
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			System.out.println("Row " + (i + 1) + " has " + cols.size() + " columns");

			// ✅ Skip rows that don’t have enough columns
			if (cols.size() < 4) {
				System.out.println("Skipping row " + (i + 1) + " because it has only " + cols.size() + " columns");
				continue;
			}

			// Extract values safely
			String sNo = cols.get(0).getText();
			String name = cols.get(1).getText();
			String productionCount = cols.get(2).getText();
			String skuCount = cols.get(3).getText();

			System.out.println(sNo + " | " + name + " | " + productionCount + " | " + skuCount);

			// ✅ Validations
			Assert.assertFalse(name.isEmpty(), "Name column is empty in row " + (i + 1));
			Assert.assertTrue(Integer.parseInt(productionCount) > 0, "Invalid production count in row " + (i + 1));
		}

	}
}
