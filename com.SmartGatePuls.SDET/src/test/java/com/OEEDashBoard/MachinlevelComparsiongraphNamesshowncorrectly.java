package com.OEEDashBoard;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class MachinlevelComparsiongraphNamesshowncorrectly extends BaseClass {
	@Test
	public void VerifyMchinelevelComparisonGraphisdisplayedTest() throws Throwable {
		// Initialize WebDriver utility for custom waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize POM class for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize POM class for Downtime Dashboard page
		OEEdashboard oe = new OEEdashboard(driver);
		// Navigate to "OEE " module via the homepage

		we.waitAndClick(hm.getOEE());

		// Click on the "oee Dashboard" link in the menu
		we.waitAndClick(oe.getOEEdashboard());

		// Waits until Filter button is clickable and then clicks it
		we.waitAndClick(oe.getFilterButton());

		// Waits until Business Unit dropdown is clickable and clicks it
		we.waitAndClick(oe.getBUDropDown());

		// Selects BU3 checkbox from Business Unit dropdown
		we.waitAndClick(oe.getBu3checkbox());

		// Collapses the Business Unit dropdown
		we.waitAndClick(oe.getCollpaseBUdropdown());

		// Opens Area dropdown
		we.waitAndClick(oe.getAreaDropDown());

		// Selects Area checkbox
		we.waitAndClick(oe.getAreaCheckox());

		// Collapses Area dropdown
		we.waitAndClick(oe.getCollpaseAreadropdown());

		// Opens Group dropdown
		we.waitAndClick(oe.getGroupDropDown());

		// Selects Group checkbox
		we.waitAndClick(oe.getGroupCheckbox());

		// Collapses Group dropdown
		we.waitAndClick(oe.getCollpaseGroupdropdown());

		// Opens Equipment dropdown
		we.waitAndClick(oe.getEquipementDropDown());

		// Selects Equipment checkbox
		we.waitAndClick(oe.getEquipementCheckbox());

		// Collapses Equipment dropdown
		we.waitAndClick(oe.getCollpaseEquipementsdropdown());

		// Click on Period dropdown
		we.waitAndClick(oe.getPeriodDropDown());

		// Select "Range" option from Period dropdown
		we.select(oe.getPeriodDropDown(), "Range");

		// Clicks on From Date field
		we.waitAndClick(oe.getFromdateSelection());

		// Clears existing value in From Date field
		oe.getFromdateSelection().clear();

		// Enters From Date value
		oe.getFromdateSelection().sendKeys("01-01-2025");

		// Clicks on To Date field
		we.waitAndClick(oe.getTodateSelection());

		// Clears existing value in To Date field
		oe.getTodateSelection().clear();

		// Enters To Date value
		oe.getTodateSelection().sendKeys("30-01-2025");

		// Clicks on Apply Filter button
		we.waitAndClick(oe.getApplyFilter());

		we.waitAndClick(oe.getMachinelevelComparisongraph());

		WebElement chart = oe.getMachinelevelComparisongraph();

		// WebElement chart = driver.findElement(By.id("group_bar_chart"));
		Assert.assertTrue(chart.isDisplayed(), "Bar chart is not displayed");

		List<WebElement> machineLabels = driver.findElements(By.xpath("//*[name()='text']"));
		for (WebElement label : machineLabels) {
			System.out.println(label.getText());
			
			List<String> expectedLegend = Arrays.asList("OEE", "AVAILABILITY", "QUALITY", "PERFORMANCE");

		}
	}
}