package com.OEEDashBoard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;

import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class OEEdashboardpagenavigationTest extends BaseClass {

	@Test
	public void OEEdashboardpagenavigationTest() throws Throwable {

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
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

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

	}
}