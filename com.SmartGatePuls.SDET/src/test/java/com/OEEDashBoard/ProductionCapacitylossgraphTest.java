package com.OEEDashBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class ProductionCapacitylossgraphTest extends BaseClass {

	@Test
	public void ProductionCapacitylossgraphTest() throws Throwable {

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

		we.waitAndClick(oe.getVeiwDetailsToggleButton());

		// Scroll to the bottom of the page to make machine tables visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement graph = driver.findElement(By.xpath("//label[text()=\"PRODUCTION CAPACITY LOSS\"]"));
		Assert.assertTrue(graph.isDisplayed(), "Production Capacity Loss graph is not displayed");

	}

}
