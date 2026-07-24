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

public class VerifytheOEETargetTabledatandPrintData extends BaseClass {

	@Test
	public void VerifytheOEETargetTabledatandPrintData() throws Throwable {

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

// Wait until table rows are visible
		List<WebElement> rows = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));

		Assert.assertTrue(rows.size() > 0, "No records found in the table.");

		System.out.println("Total Records: " + rows.size());

// Print table data
		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

			System.out.print("Row " + (i + 1) + " : ");

			for (WebElement column : columns) {
				System.out.print(column.getText().trim() + " | ");
			}

			System.out.println();
		}

	}
}
