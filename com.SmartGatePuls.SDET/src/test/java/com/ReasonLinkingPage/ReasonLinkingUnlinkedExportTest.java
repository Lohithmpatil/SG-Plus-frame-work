package com.ReasonLinkingPage;
// Package declaration

import org.openqa.selenium.By;
// Import Selenium By class to locate elements

import org.openqa.selenium.WebElement;
// Import Selenium WebElement class for element representation

import org.testng.Assert;
// Import TestNG Assert class for assertions

import org.testng.annotations.Test;
// Import TestNG Test annotation

import com.sgplus.erp.genericutility.BaseClass;
// Import BaseClass for common setup and teardown

import com.sgplus.erp.genericutility.WebDriverUtility;
// Import WebDriverUtility for common WebDriver helper methods

import com.sgplus.erp.pomRepository.HomePage;
// Import HomePage Page Object Model (POM) class

public class ReasonLinkingUnlinkedExportTest extends BaseClass {
// Test class extending BaseClass to inherit setup/teardown

	@Test
	// Mark this method as a TestNG test method
	public void Reasonlinkingpage() throws InterruptedException {
		// Test method for verifying reason linking page export functionality

		WebDriverUtility we = new WebDriverUtility();
		// Instantiate WebDriverUtility for WebDriver helper functions

		HomePage hm = new HomePage(driver);
		// Instantiate HomePage POM using the WebDriver instance

		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);
		// Instantiate ReasonLinking POM using the WebDriver instance

		we.waitAndClick(hm.getDownTime());
		// Wait for and click on the "DownTime" element from HomePage

		we.waitAndClick(rs.getReasonLinking());
		// Wait for and click the "ReasonLinking" menu option

		we.waitAndClick(rs.getBUDropDown());
		// Wait for and click the Business Unit dropdown to expand it

		we.select(rs.getBUDropDown(), "BU3");
		// Select "BU3" option from the Business Unit dropdown by visible text

		we.waitAndClick(rs.getEquipmentDropDown());
		// Wait for and click Equipment dropdown to expand it

		we.waitAndClick(rs.getEquipmentCheckbox());
		// Wait for and select an equipment checkbox

		we.waitAndClick(rs.getFromDate());
		// Wait for and click the From Date input to activate date picker

		we.waitForElement(driver, rs.getFromDate());
		// Explicit wait for the From Date input element to be visible

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();
		// Clear any existing text in the From Date input field

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");
		// Enter the From Date as "01-01-2025"

		we.waitAndClick(rs.getToDate());
		// Wait for and click the To Date input to activate date picker

		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).clear();
		// Clear any existing text in the To Date input field

		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).sendKeys("02-01-2025");
		// Enter the To Date as "02-01-2025"

		we.waitAndClick(rs.getLinkDropDown());
		// Wait for and click the Link dropdown to expand it

		we.select(rs.getLinkDropDown(), "Unlinked");
		// Select "Unlinked" option from the Link dropdown

		we.waitAndClick(rs.getSearchButton());
		// Wait for and click the Search button to filter results

		we.waitAndClick(rs.getExportButton());
		// Wait for and click the Export button to export the filtered data

		we.waitAndClick(rs.getSuccessfullyExported());
		// Wait for the success toast/message indicating export completion

		WebElement successToast = rs.getSuccessfullyExported();
		// Store the success message element in a variable

		// Assertion
		Assert.assertTrue(successToast.isDisplayed(), "Export success message not displayed!");
		// Assert that the success export message is visible on the page
	}

}