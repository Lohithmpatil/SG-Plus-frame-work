package com.DowntimeTarget;

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
import com.sgplus.erp.pomRepository.DowntimeTarget;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifytheDowntimeTargetTabledataAndPrintData  extends BaseClass{
	
	@Test
	public void VerifytheDowntimeTargetTabledataAndPrintDat() throws Throwable {

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
