package com.OEEDashBoard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class VerifytheShiftproductionreportEquipmentandPeriodwise extends BaseClass {
	@Test
	public void VerifytheShiftproductionreportEquipmentandPeriodwise() throws Throwable {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		we.waitAndClick(oe.getShiftProductionGropByDrodown());

		we.select(oe.getShiftProductionGropByDrodown(), "Equipment & Period");

		// WebElement dropdown =
		// driver.findElement(By.xpath("//select[@id=\"groupBy\"]"));
		we.waitAndClick(oe.getShiftProductionGropByDrodown());
		WebElement dropdown = oe.getShiftProductionGropByDrodown();
		Select select = new Select(dropdown);

		String selectedOption = select.getFirstSelectedOption().getText();

		if (selectedOption.equals("Equipment & Period")) {
			System.out.println("PASS: Equipment is selected in Group By dropdown");
		} else {
			System.out.println("FAIL: Expected 'Equipment' but found: " + selectedOption);
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[1]")));

		String header = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]")).getText();

		if (header.equals("02-01-2025")) {
			System.out.println("PASS: Table header is Equipment");
		} else {
			System.out.println("FAIL: Header is " + header);
		}
	}

}
