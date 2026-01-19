package com.DowntimeModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class testing extends BaseClass {

	@Test
	public void DowntimeBestMachineTest() throws Throwable {

		// Initialize WebDriver utility for custom waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize POM class for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize POM class for Downtime Dashboard page
		DowntiemDashboard dt = new DowntiemDashboard(driver);

		// Wait for the page and DOM to fully load
		we.waitUntilPageLoad(driver);
		we.waitForElementInDOM(driver);

		// Navigate to "Down Time" module via the homepage
		we.waitAndClick(hm.getDownTime());

		// Click on the "Downtime Dashboard" link in the menu
		we.waitAndClick(hm.getDowntimeDashboard());

		// Click the "Filter" button to open filter options
		we.waitAndClick(dt.getFilterButton());

		// Open BU (Business Unit) dropdown
		we.waitAndClick(dt.getBUDropDown());

		we.waitAndClick(dt.getBu3checkbox());
		we.waitAndClick(dt.getBUDropDown());
		// Select "BU3" from BU dropdown
		// we.select(dt.getBUDropDown(), "BU3");
		//driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();
		// Open Area dropdown
		we.waitAndClick(dt.getAreaDropDown());

		we.waitAndClick(dt.getAreaCheckox());
	
		
		//driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Open Group dropdown
		we.waitAndClick(dt.getGroupDropDown());

		we.waitAndClick(dt.getGroupCheckbox());

		// Select "Unistage" group from dropdown
		//we.select(dt.getGroupDropDown(), "Unistage");
		
	    driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();
		//.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Open Equipment dropdown
		we.waitAndClick(dt.getEquipementDropDown());

		// Select a checkbox from equipment list (selects one equipment)
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// Close the equipment dropdown
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		// Open Period dropdown
		we.waitAndClick(dt.getPeriodDropDown());

		// Select "Year" from Period dropdown
		we.select(dt.getPeriodDropDown(), "Year");

		// Open Shift dropdown
		we.waitAndClick(dt.getShiftDropDown());

		// Select "All" shifts
		we.select(dt.getShiftDropDown(), "All");

		// Click on Apply Filter button to load dashboard data
		we.waitAndClick(dt.getApplyFilter());


	}
}