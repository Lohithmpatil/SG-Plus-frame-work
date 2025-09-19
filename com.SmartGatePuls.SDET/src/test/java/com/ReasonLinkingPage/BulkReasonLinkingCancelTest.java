package com.ReasonLinkingPage;

import java.time.Duration;
// Import required Java and Selenium classes

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass; // Base class with setup/teardown logic
import com.sgplus.erp.genericutility.WebDriverUtility; // Custom WebDriver utility methods
import com.sgplus.erp.pomRepository.HomePage; // Page Object for Home Page

public class BulkReasonLinkingCancelTest extends BaseClass {

	@Test
	public void BulkReasonLinkingCancelTest() throws InterruptedException {

		// Create utility object for custom WebDriver actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize HomePage POM
		HomePage hm = new HomePage(driver);

		// Initialize ReasonLinking POM
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		we.waitForElementInDOM(driver);

		// Click on the "DownTime" menu in the sidebar
		we.waitAndClick(hm.getDownTime());

		// Click on the "Reason Linking" tab/page
		we.waitAndClick(rs.getReasonLinking());

		// Click to expand BU (Business Unit) dropdown
		we.waitAndClick(rs.getBUDropDown());

		// Select "BU3" from BU dropdown
		we.select(rs.getBUDropDown(), "BU3");

		// Expand Equipment dropdown
		we.waitAndClick(rs.getEquipmentDropDown());

		// Select a checkbox inside Equipment list
		we.waitAndClick(rs.getEquipmentCheckbox());

		// Click on "From Date" calendar icon
		we.waitAndClick(rs.getFromDate());

		// Wait for the From Date element to be ready
		we.waitForElement(driver, rs.getFromDate());

		// Clear the current date in the input box
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

		// Enter a custom date manually
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");

		// Open the "Source" dropdown
		we.waitAndClick(rs.getSourceDropDown());

		// Select the 2nd option in the source dropdown (index 1)
		we.select(rs.getSourceDropDown(), 1);

		// Open "Link" dropdown
		we.waitAndClick(rs.getLinkDropDown());

		// Select "All" option in the Link dropdown
		we.select(rs.getLinkDropDown(), "All");

		// Click the "Search" button to fetch matching results
		we.waitAndClick(rs.getSearchButton());

		// Click the "Bulk Link" button to start bulk linking
		we.waitAndClick(rs.getBulkLinkButton());

		// Hover over the checkbox before clicking it (maybe for tooltip/UI reason)
		we.mouseOverOnElement1(driver, rs.getCheckBoxForBulkLink());

		// Select the checkbox to mark a record for bulk link
		we.waitAndClick(rs.getCheckBoxForBulkLink());

		// Click on the 2nd "Bulk Link" button to proceed with selected records
		we.waitAndClick(rs.getBulkLinkButton1());

		// Open "Department Group" dropdown
		we.waitAndClick(rs.getDepartmentGroupDropdown());

		// Select the 2nd item from Department Group (index 1)
		we.select(rs.getDepartmentGroupDropdown(), 1);

		// Open "Department" dropdown
		we.waitAndClick(rs.getBulkDepartmentDropdown());

		// Select 2nd item from Department dropdown
		we.select(rs.getBulkDepartmentDropdown(), 1);

		// Expand the "Reason" dropdown
		we.waitAndClick(rs.getReasonDropdownForBulkLink());

		// Select the 2nd reason from dropdown
		we.select(rs.getReasonDropdownForBulkLink(), 1);

		// Click on the comment field
		we.waitAndClick(rs.getCommentField());

		// Enter comment text for the reason linking
		rs.getCommentField().sendKeys("Bulk Reason linking Automation test reason");

		// Click on the "Save" button to submit bulk linking
		we.waitAndClick(rs.getSaveButton());

		// Click "Cancel" in the confirmation popup
		we.waitAndClick(rs.getCancelForBulkLink());

		we.waitAndClick(rs.getCancelbutton1());

		// ✅ Wait for modal to disappear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean isModalClosed = wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'modal-content')]")));

		// ✅ Validate
		Assert.assertTrue(isModalClosed, "❌ Cancel did not close the modal!");
	}

}
