package com.CycleTimeDashboard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.CylceTimeDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifytheTooltipdatabyselectingByOperatorvalue  extends BaseClass{
	

	@Test
	public void VerifytheTooltipdatabyselectingByOperatorvalue() throws Throwable {

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

		we.waitAndClick(cd.getXaxisDropdown());

		we.select(cd.getXaxisDropdown(), "By Operator");
		// Validate Plotly Bar Chart using Selenium Java

		// Wait for chart to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Validate graph is displayed
		WebElement chart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'plotly')]")));

		Assert.assertTrue(chart.isDisplayed(), "Bar chart is not displayed");

		// Validate bars count
		List<WebElement> bars = driver
				.findElements(By.xpath("//*[name()='svg']//*[contains(@class,'barlayer')]//*[name()='path']"));

		// Hover on first bar
		Actions actions = new Actions(driver);

		WebElement firstBar = bars.get(0);

		actions.moveToElement(firstBar).pause(Duration.ofSeconds(2)).perform();

		// Wait for tooltip
		WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myHover")));

		// Get tooltip text
		String tooltipText = tooltip.getText();

		System.out.println("Tooltip Text: " + tooltipText);

		// Validate tooltip
		Assert.assertFalse(tooltipText.trim().isEmpty(), "Tooltip is empty");

		Assert.assertTrue(tooltipText.contains("Production") || tooltipText.contains("Set Value")
				|| tooltipText.contains("Weighted Avg"), "Tooltip validation failed");
	}
}

