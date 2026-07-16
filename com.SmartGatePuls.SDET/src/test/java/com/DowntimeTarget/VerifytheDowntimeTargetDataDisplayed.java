package com.DowntimeTarget;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeTarget;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifytheDowntimeTargetDataDisplayed extends BaseClass {

	@Test
	public void VerifytheDowntimeTargetDataDisplayed() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		DowntimeTarget dt = new DowntimeTarget(driver);

		we.waitAndClick(hm.getSettings());
		// Click on Cycle Time module from home page
		we.waitAndClick(dt.getDowntimeTargetPage());

		// Click on Filter button to open filter options
		we.waitAndClick(dt.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click it
		we.waitAndClick(dt.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(dt.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(dt.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown

		we.select(dt.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it

		we.waitAndClick(dt.getGroupDropDown());

		// Select "Unistage" from the Group dropdown

		we.select(dt.getGroupDropDown(), "Unistage");

		// Click on Apply Filter button to load data
		we.waitAndClick(dt.getApplyFilter());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

		Assert.assertTrue(table.isDisplayed(), "Table is not displayed.");

	}
}
