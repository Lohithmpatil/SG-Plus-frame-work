package com.RCAReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.RCAReport;

public class VerifytheElementWiseSummaryViewTable extends BaseClass{

	

	@Test
	public void VerifytheElementWiseSummaryViewTable() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		// Create CycleTimeDashboard object to access dashboard elements
		RCAReport rc = new RCAReport(driver);

		// Click on Cycle Time module from home pageA
		we.waitAndClick(hm.getCyletime());

		// Click on Cycle Time Dashboard menu
		we.waitAndClick(rc.getRCAReportNavigation());

		// Click on Filter button to open filter options
		we.waitAndClick(rc.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click it
		we.waitAndClick(rc.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(rc.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(rc.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown

		we.select(rc.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it

		we.waitAndClick(rc.getGroupDropDown());

		// Select "Unistage" from the Group dropdown

		we.select(rc.getGroupDropDown(), "Unistage");

		// Commented out code: Wait and select an Equipment dropdown option (not being
		// used)

		we.waitAndClick(rc.getEquipementDropDown());

		// Selects Equipment checkbox
		we.waitAndClick(rc.getEquipementCheckbox());

		// Collapses Equipment dropdown
		we.waitAndClick(rc.getCollpaseEquipementsdropdown());

		// Click on Period dropdown
		we.waitAndClick(rc.getPeriodDropDown());

		// Select "Range" option from Period dropdown
		we.select(rc.getPeriodDropDown(), "Range");

		// Clicks on From Date field
		we.waitAndClick(rc.getFromdateSelection());

		// Clears existing value in From Date field
		rc.getFromdateSelection().clear();

		// Enters From Date value
		rc.getFromdateSelection().sendKeys("01-04-2023");

		// Clicks on To Date field
		we.waitAndClick(rc.getTodateSelection());

		// Clears existing value in To Date field
		rc.getTodateSelection().clear();

		// Enters To Date value
		rc.getTodateSelection().sendKeys("30-04-2023");

		we.waitAndClick(rc.getRecipeDropDown());

		we.waitAndClick(rc.getRecipeDropDownCheckbox());

		we.waitAndClick(rc.getCollapseRecipedropdown());

		// Click on Apply Filter button to load data
		we.waitAndClick(rc.getApplyFilter());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.id("element_table")));

		Assert.assertTrue(table.isDisplayed(), "Element Wise Summary View table is not displayed.");
	}
}
