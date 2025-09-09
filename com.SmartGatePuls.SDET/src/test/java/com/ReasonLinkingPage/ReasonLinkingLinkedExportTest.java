package com.ReasonLinkingPage;  // Package containing Reason Linking related tests

// Import required Selenium and TestNG classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// Import project-specific base classes and utilities
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class ReasonLinkingLinkedExportTest extends BaseClass {  // Test class extending BaseClass for setup and teardown

    @Test
    public void Reasonlinkingpage() throws InterruptedException {

        // Create an instance of WebDriverUtility for reusable wait and select methods
        WebDriverUtility we = new WebDriverUtility();

        // Initialize HomePage page object to interact with homepage elements
        HomePage hm = new HomePage(driver);

        // Initialize ReasonLinking page object to interact with Reason Linking page elements
        com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

        // Click on the Downtime section from homepage menu
        we.waitAndClick(hm.getDownTime());

        // Click on the Reason Linking submenu under Downtime menu
        we.waitAndClick(rs.getReasonLinking());

        // Click to open the Business Unit dropdown
        we.waitAndClick(rs.getBUDropDown());

        // Select "BU3" from Business Unit dropdown
        we.select(rs.getBUDropDown(), "BU3");

        // Click to open Equipment dropdown list
        we.waitAndClick(rs.getEquipmentDropDown());

        // Select equipment by clicking its checkbox
        we.waitAndClick(rs.getEquipmentCheckbox());

        // Click on the From Date field to activate date input
        we.waitAndClick(rs.getFromDate());

        // Wait until From Date input element is ready
        we.waitForElement(driver, rs.getFromDate());

        // Clear any existing text in the From Date input field
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

        // Enter "01-01-2025" as the From Date
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

        // Click on the To Date field to activate it
        we.waitAndClick(rs.getToDate());

        // Clear existing text in the To Date input field
        driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).clear();

        // Enter "02-01-2025" as the To Date
        driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).sendKeys("02-01-2025");

        // Click on the Link dropdown to open it
        we.waitAndClick(rs.getLinkDropDown());

        // Select "Linked" option from the Link dropdown
        we.select(rs.getLinkDropDown(), "Linked");

        // Click on the Search button to apply filters and display results
        we.waitAndClick(rs.getSearchButton());

        // Click on the Export button to export the filtered data
        we.waitAndClick(rs.getExportButton());

        // Wait and click the success toast message indicating export success
        we.waitAndClick(rs.getSuccessfullyExported());

        // Store the success toast WebElement for validation
        WebElement successToast = rs.getSuccessfullyExported();

        // Assertion to verify that the export success message is displayed
        Assert.assertTrue(successToast.isDisplayed(), "Export success message not displayed!");

    }

}