package com.DowntimeEnhacementPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeEnhacement;
import com.sgplus.erp.pomRepository.HomePage;

public class NavigateToDowntimeEnhancementPageTest extends BaseClass {

    // Test annotation marks this method as a TestNG test case
    @Test 
    public void NavigateToDowntimeEnhancementPage() throws InterruptedException {

        // Creates instance of WebDriverUtility for reusable methods like waitAndClick, select, etc.
        WebDriverUtility we = new WebDriverUtility(); 

        // Initializes HomePage object to interact with elements on the Home Page (Page Object Model)
        HomePage hm = new HomePage(driver); 

        // Initializes DowntimeEnhacement object to interact with elements on the Downtime Enhancement page
        DowntimeEnhacement de = new DowntimeEnhacement(driver);

        // Waits for the "DownTime" link or button on the Home Page and clicks it
        we.waitAndClick(hm.getDownTime());

        // Waits for and clicks the "Enhancement Module" link/button on the Downtime Enhancement page
        we.waitAndClick(de.getEnhacementModule());

        // Waits for and clicks the "Filter" button to open filter options on the Downtime Enhancement page
        we.waitAndClick(de.getFilterButton());

        // Waits for and clicks the "Business Unit" dropdown
        we.waitAndClick(de.getBUDropDown());

        // Selects "BU3" from the Business Unit dropdown
        we.select(de.getBUDropDown(), "BU3");

        // Waits for and clicks the "Area" dropdown
        we.waitAndClick(de.getAreaDropDown());

        // Selects "All" from the Area dropdown
        we.select(de.getAreaDropDown(), "All");

        // Waits for and clicks the "Group" dropdown
        we.waitAndClick(de.getGroupDropDown());

        // Selects "All" from the Group dropdown
        we.select(de.getGroupDropDown(), "All");

        // Waits for and clicks the "Equipment" dropdown
        we.waitAndClick(de.getEquipementDropDown());

        // Waits for and clicks the checkbox for selecting equipment
        we.waitAndClick(de.getCheckBoxEquipements());

        // Clears any existing text in the "From Date" input field (used for filtering by date)
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

        // Inputs the date "01-01-2025" into the "From Date" input field to filter results starting from this date
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

        // Waits for and clicks the "Apply Filter" button to apply the selected filters
        we.waitAndClick(de.getApplyFilter());

        // Waits for and clicks the table (presumably to load the data after filters are applied)
        we.waitAndClick(de.getTable());

        // Retrieves the header text from the Downtime Enhancement page to confirm we are on the correct page
        WebElement pageHeader = de.getHeaderText();

        // Verifies that the page header is displayed, confirming successful navigation to the Downtime Enhancement page
        Assert.assertTrue(pageHeader.isDisplayed(), "Failed to navigate to Downtime Enhancement Page.");
    }
}