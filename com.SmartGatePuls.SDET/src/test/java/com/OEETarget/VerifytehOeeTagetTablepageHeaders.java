package com.OEETarget;



import java.time.Duration;
import java.util.List;

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

public class VerifytehOeeTagetTablepageHeaders  extends BaseClass{
	

	@Test
	public void VerifytehOeeTagetTablepageHeaders() throws Throwable {

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
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		String[] expectedHeaders = {
		        "Sno",
		        "Machine",
		        "OEE",
		        "Date",
		        "Modified OEE",
		        "Action"
		};

		// Wait until all table headers are visible
		List<WebElement> actualHeaders = wait.until(
		        ExpectedConditions.visibilityOfAllElementsLocatedBy(
		                By.xpath("//table/thead/tr/th"))
		);

		// Print all headers
		System.out.println("Actual Table Headers:");
		for (int i = 0; i < actualHeaders.size(); i++) {
		    System.out.println("Header " + (i + 1) + " : " + actualHeaders.get(i).getText().trim());
		}


}
}