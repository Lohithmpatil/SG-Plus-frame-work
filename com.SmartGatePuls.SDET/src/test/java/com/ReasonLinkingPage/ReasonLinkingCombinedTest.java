package com.ReasonLinkingPage; // Package declaration for Reason Linking page test cases

// Import necessary Java and Selenium libraries
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass; // Base class contains setup and teardown logic
import com.sgplus.erp.genericutility.WebDriverUtility; // Utility class for WebDriver operations
import com.sgplus.erp.pomRepository.HomePage; // Page Object Model class for HomePage elements

public class ReasonLinkingCombinedTest extends BaseClass { // Test class that extends BaseClass for driver setup

	@Test
	public void ReasonLinkingCombinedTest() throws InterruptedException {

		// Create object of WebDriverUtility to access utility methods
		WebDriverUtility we = new WebDriverUtility();

		// Create object of HomePage POM to interact with homepage elements
		HomePage hm = new HomePage(driver);

		// Create object of ReasonLinking POM to access Reason Linking page elements
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		// Click on "Downtime" tab in the home page menu
		we.waitAndClick(hm.getDownTime());

		// Click on "Reason Linking" menu option
		we.waitAndClick(rs.getReasonLinking());

		// Click on Business Unit (BU) dropdown
		we.waitAndClick(rs.getBUDropDown());

		// Select "BU3" from the BU dropdown list
		we.select(rs.getBUDropDown(), "BU3");

		// Click on Equipment dropdown
		we.waitAndClick(rs.getEquipmentDropDown());

		// Select the checkbox to choose equipment
		we.waitAndClick(rs.getEquipmentCheckbox());

		// Click on the From Date input field
		we.waitAndClick(rs.getFromDate());

		// Wait for From Date field to be interactable
		we.waitForElement(driver, rs.getFromDate());

		// Clear existing value in From Date field
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

		// Enter new From Date (14-Jan-2025)
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");

		// Click on Link Type dropdown (Linked/Unlinked/All)
		we.waitAndClick(rs.getLinkDropDown());

		// Select "All" from the Link dropdown to include both linked and unlinked data
		we.select(rs.getLinkDropDown(), "All");

		// Click the Search button to apply filters and display results
		we.waitAndClick(rs.getSearchButton());

		// Locate the table element that displays filtered data
		WebElement table = driver.findElement(By.id("expanded-table"));

		// Validate if the table is displayed and print result to console
		if (table.isDisplayed()) {
			System.out.println("ALL data visible on the page");
		} else {
			System.out.println("All data is not visible");
		}

	}
}