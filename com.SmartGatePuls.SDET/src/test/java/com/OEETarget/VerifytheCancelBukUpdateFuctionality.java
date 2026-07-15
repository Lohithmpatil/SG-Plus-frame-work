package com.OEETarget;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEETarget;

public class VerifytheCancelBukUpdateFuctionality extends BaseClass {

	@Test
	public void VerifytheCancelBukUpdateFuctionality() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		OEETarget oe = new OEETarget(driver);

		we.waitAndClick(hm.getSettings());
		// Click on Cycle Time module from home page
		we.waitAndClick(oe.getOEETargetPage());

		// Click on Filter button to open filter options
		we.waitAndClick(oe.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click it
		we.waitAndClick(oe.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(oe.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(oe.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown

		we.select(oe.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it

		we.waitAndClick(oe.getGroupDropDown());

		// Select "Unistage" from the Group dropdown

		we.select(oe.getGroupDropDown(), "Unistage");

		// Click on Apply Filter button to load data
		we.waitAndClick(oe.getApplyFilter());

		we.waitAndClick(oe.getBulkButton());
		
		we.waitAndClick(oe.getBulkButton());

		we.waitAndClick(oe.getCheckBOx());
		
		we.waitAndClick(oe.getBulkButton2());
		we.waitAndClick(oe.getOEETargetTextFeild());

		oe.getOEETargetTextFeild().clear();

		oe.getOEETargetTextFeild().sendKeys("50");
		
		we.waitAndClick(oe.getCancelButton());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Verify popup is closed
		wait.until(ExpectedConditions.invisibilityOf(oe.getUpdateButton()));

		Assert.assertTrue(
		    driver.findElements(By.xpath("//h4[text()='OEE Bulk Update']")).isEmpty(),
		    "Bulk Update popup is still displayed."
		);

		System.out.println("Cancel button functionality verified successfully.");
		
		

	}
}
