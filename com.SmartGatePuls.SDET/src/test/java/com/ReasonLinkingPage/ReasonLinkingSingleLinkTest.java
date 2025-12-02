package com.ReasonLinkingPage;
// Package declaration

import org.openqa.selenium.By;
// Import Selenium By class for locating elements

import org.testng.Assert;
// Import TestNG Assert class for assertions

import org.testng.annotations.Test;
// Import TestNG Test annotation

import com.sgplus.erp.genericutility.BaseClass;
// Import BaseClass from project utilities

import com.sgplus.erp.genericutility.WebDriverUtility;
// Import WebDriverUtility for common webdriver operations

import com.sgplus.erp.pomRepository.HomePage;
// Import HomePage POM class

public class ReasonLinkingSingleLinkTest extends BaseClass {
// Test class extending BaseClass for setup/teardown

	@Test
	// TestNG annotation to mark this as a test method
	public void ReasonLinkingFunctionalityTest() throws InterruptedException {
		// Main test method which throws InterruptedException

		WebDriverUtility we = new WebDriverUtility();
		// Create instance of utility class for webdriver actions

		HomePage hm = new HomePage(driver);
		// Create HomePage POM object with driver

		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);
		// Create ReasonLinking POM object

		we.waitForElementInDOM(driver);
		// Wait for the DOM elements to be loaded before proceeding

		we.waitAndClick(hm.getDownTime());
		// Wait for and click the "DownTime" element from HomePage

		we.waitAndClick(rs.getReasonLinking());
		// Wait for and click the "ReasonLinking" element

		we.waitAndClick(rs.getBUDropDown());
		// Wait for and click Business Unit dropdown

		we.select(rs.getBUDropDown(), "BU3");
		// Select "BU3" option from Business Unit dropdown

		we.waitAndClick(rs.getEquipmentDropDown());
		// Wait for and click Equipment dropdown

		we.waitAndClick(rs.getEquipmentCheckbox());
		// Wait for and select an equipment checkbox

		we.waitAndClick(rs.getFromDate());
		// Wait for and click the "From Date" field to open date picker

		we.waitForElement(driver, rs.getFromDate());
		// Explicit wait for the From Date element to be visible

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();
		// Clear the input field in the date picker

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");

		// Click on the Source dropdown to open it
		we.waitAndClick(rs.getSourceDropDown());

		// Select the source option at index 1 from the dropdown list
		we.select(rs.getSourceDropDown(), 1);

		// Enter the date "14-01-2025"

		we.waitAndClick(rs.getLinkDropDown());
		// Wait for and click the Link dropdown

		we.select(rs.getLinkDropDown(), "Unlinked");
		// Select "Unlinked" from the Link dropdown

		we.waitAndClick(rs.getSearchButton());
		// Wait for and click the Search button

		we.waitAndClick(rs.getLinkButton());
		// Wait for and click the Link button to initiate linking

		we.waitAndClick(rs.getDepartmentGroupDropdown());
		// Wait for and click Department Group dropdown

		we.select(rs.getDepartmentGroupDropdown(), 1);
		// Select the first option in Department Group dropdown (index-based)

		we.waitAndClick(rs.getDepartmentDropdown());
		// Wait for and click Department dropdown

		// we.select(rs.getDepartmentDropdown(), "Electrical");
		// (Commented out) Select "Electrical" from Department dropdown

		we.select(rs.getDepartmentDropdown(), 1);
		// Select the first option in Department dropdown (index-based)

		// Click the dropdown to expand
		we.waitAndClick(rs.getReason());
		// Wait for and click the Reason dropdown

		we.waitAndClick(rs.getReasonOption());
		// Wait for and select a reason option

		we.waitAndClick(rs.getCommentField());
		// Wait for and click the comment input field

		rs.getCommentField().sendKeys("Automation test reason");
		// Enter comment text into the comment field

		we.waitAndClick(rs.getSaveButton());
		// Wait for and click the Save button to save the link

		we.waitAndClick(rs.getSuccessMsg());
		// Wait for and click the success message (to ensure it appeared)

		String actualMsg = rs.getSuccessMsg().getText();
		// Get the text of the success message displayed

		String expectedMsg = "Reason(s) linked to downtime successfully";
		// Expected success message

		// Assertion to verify success message is as expected
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Expected success message not found! Actual: " + actualMsg);
		// Assert that actual message contains expected message, else fail test with
		// message
	}

}