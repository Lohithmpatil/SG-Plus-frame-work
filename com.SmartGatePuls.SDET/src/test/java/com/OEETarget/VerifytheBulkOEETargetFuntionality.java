package com.OEETarget;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEETarget;

public class VerifytheBulkOEETargetFuntionality extends BaseClass {

	@Test
	public void VerifytheBulkOEETargetFuntionality() throws Throwable {

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

		we.waitAndClick(oe.getCheckBOx());
		
		we.waitAndClick(oe.getBulkButton2());
		we.waitAndClick(oe.getOEETargetTextFeild());

		oe.getOEETargetTextFeild().clear();

		oe.getOEETargetTextFeild().sendKeys("50");

		we.waitAndClick(oe.getUpdateButton());

		we.waitAndClick(oe.getSaveChangesBtn());

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement successMsg = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'Toastify__toast-body') or contains(text(),'Equipment OEE target updated successfully')]")));

		String actualMessage = successMsg.getText().trim();

		System.out.println("Success Message: " + actualMessage);

		Assert.assertEquals(actualMessage, "10 Equipment OEE target updated successfully",
				"Success message is not matching.");
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until toast disappears
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.cssSelector(".Toastify__toast-body")));
	}

}
