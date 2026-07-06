package com.OverallSummary;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.CycletimeOverallSummary;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifuytheOverallProductionLossData extends BaseClass {

	@Test
	public void VerifytheOverallProductionData() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		// Create CycleTimeDashboard object to access dashboard elements
		CycletimeOverallSummary os = new CycletimeOverallSummary(driver);

		// Click on Cycle Time module from home page
		we.waitAndClick(hm.getCyletime());

		// Click on Cycle Time Dashboard menu
		we.waitAndClick(os.getOverallSummarypageNavigation());

		// Click on Filter button to open filter options
		we.waitAndClick(os.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click ita
		we.waitAndClick(os.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(os.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(os.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown

		we.select(os.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it

		we.waitAndClick(os.getGroupDropDown());

		// Select "Unistage" from the Group dropdown

		we.select(os.getGroupDropDown(), "Unistage");

		// Commented out code: Wait and select an Equipment dropdown option (not being
		// used)

		we.waitAndClick(os.getEquipementDropDown());

		// Selects Equipment checkbox
		we.waitAndClick(os.getEquipementCheckbox());

		// Collapses Equipment dropdown
		we.waitAndClick(os.getCollpaseEquipementsdropdown());

		// Click on Period dropdown
		we.waitAndClick(os.getPeriodDropDown());

		// Select "Range" option from Period dropdown
		we.select(os.getPeriodDropDown(), "Range");

		// Clicks on From Date field
		we.waitAndClick(os.getFromdateSelection());

		// Clears existing value in From Date field
		os.getFromdateSelection().clear();

		// Enters From Date value
		os.getFromdateSelection().sendKeys("01-01-2025");

		// Clicks on To Date field
		we.waitAndClick(os.getTodateSelection());

		// Clears existing value in To Date field
		os.getTodateSelection().clear();

		// Enters To Date value
		os.getTodateSelection().sendKeys("30-01-2025");

		// Click on Apply Filter button to load data
		we.waitAndClick(os.getApplyFilter());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// Wait until the first value is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[@class='d-flex justify-content-between align-items-center mt-4']")
		));

		List<WebElement> rows = driver.findElements(
		    By.xpath("//div[@class='d-flex justify-content-between align-items-center mt-4']")
		);

		System.out.println("========= OVERALL PRODUCTION LOSS =========");

		for (WebElement row : rows) {
		    System.out.println(row.getText());
		}

		System.out.println("===========================================");

	}
}