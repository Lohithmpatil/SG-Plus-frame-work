package com.ReasonLinkingPage;
// Package declaration

import java.util.List;
// Import List for handling collections of WebElements

import org.openqa.selenium.By;
// Import Selenium By class for locating elements

import org.openqa.selenium.WebElement;
// Import Selenium WebElement class for interacting with page elements

import org.testng.annotations.Test;
// Import TestNG Test annotation

import com.sgplus.erp.genericutility.BaseClass;
// Import BaseClass for setup and teardown methods

import com.sgplus.erp.genericutility.WebDriverUtility;
// Import WebDriverUtility for WebDriver helper methods

import com.sgplus.erp.pomRepository.HomePage;
// Import HomePage Page Object Model class

public class ReasonLinkingUnlinkedFilterTest extends BaseClass {
// Test class extending BaseClass to inherit common setup/teardown

	@Test
	// Mark this method as a TestNG test
	public void ReasonLinkingUnlinkedFilterTest() throws InterruptedException {
		// Test method for filtering unlinked reason linking records

		WebDriverUtility we = new WebDriverUtility();
		// Create instance of WebDriverUtility for helper methods

		HomePage hm = new HomePage(driver);
		// Create HomePage POM object using WebDriver instance

		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);
		// Create ReasonLinking POM object using WebDriver instance

		we.waitAndClick(hm.getDownTime());
		// Wait for and click the "DownTime" menu option from HomePage

		we.waitAndClick(rs.getReasonLinking());
		// Wait for and click the "ReasonLinking" submenu option

		we.waitAndClick(rs.getBUDropDown());
		// Wait for and click Business Unit dropdown to expand it

		we.select(rs.getBUDropDown(), "BU3");
		// Select "BU3" from Business Unit dropdown by visible text

		we.waitAndClick(rs.getEquipmentDropDown());
		// Wait for and click Equipment dropdown to expand it

		we.waitAndClick(rs.getEquipmentCheckbox());
		// Wait for and select an equipment checkbox

		we.waitAndClick(rs.getFromDate());
		// Wait for and click From Date input field

		we.waitForElement(driver, rs.getFromDate());
		// Explicitly wait until the From Date input field is visible

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();
		// Clear the existing date in the From Date input field

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");
		// Enter the date "14-01-2025" in the From Date field

		we.waitAndClick(rs.getLinkDropDown());
		// Wait for and click the Link dropdown to expand it

		we.select(rs.getLinkDropDown(), "Unlinked");
		// Select "Unlinked" option from the Link dropdown

		we.waitAndClick(rs.getSearchButton());
		// Wait for and click the Search button to apply filters

		// Get all table rows excluding the header row
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='expanded-table']/tbody/tr"));
		// Print the total number of rows found in the table
		System.out.println("Total Rows: " + rows.size());

		// Get all header columns (th elements)
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='expanded-table']/thead/tr/th"));
		// Print the total number of columns in the table
		System.out.println("Total Columns: " + cols.size());

		boolean found = false;
		// Loop through each row to check if it contains the text "UnLinked"
		for (WebElement row : rows) {
			if (row.getText().contains("UnLinked")) { // Check if row contains "UnLinked" text
				found = true;
				break; // Exit loop once found
			}
		}

		// Print result based on whether "UnLinked" record was found
		if (found) {
			System.out.println("UnLinked record found!");
		} else {
			System.out.println("No Unlinked record found.");
		}

	}

}