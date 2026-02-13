package com.ReasonLinkingPage;  // Package declaration to organize the class within the ReasonLinkingPage package

import org.openqa.selenium.By;  // Importing Selenium's By class for locating web elements
import org.testng.annotations.Test;  // Importing TestNG annotation for marking test methods

import com.sgplus.erp.genericutility.BaseClass;  // Importing BaseClass which provides WebDriver setup and teardown
import com.sgplus.erp.genericutility.WebDriverUtility;  // Importing utility class for reusable WebDriver methods
import com.sgplus.erp.pomRepository.HomePage;  // Importing Page Object Model class for HomePage elements

public class ReasonLinkingNavigationTest extends BaseClass {  // Declaring the test class, extending BaseClass for setup/teardown

    @Test  // Marks this method as a TestNG test method
    public void ReasonLinkingNavigationTest() throws InterruptedException {

        WebDriverUtility we = new WebDriverUtility();  // Create an instance of WebDriverUtility for helper methods

        HomePage hm = new HomePage(driver);  // Initialize the HomePage object to access homepage elements
        com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);  // Initialize ReasonLinking POM to access page elements

        we.waitAndClick(hm.getDownTime());  // Wait for and click on the "DownTime" menu item on the homepage

        we.waitAndClick(rs.getReasonLinking());  // Wait for and click the "Reason Linking" submenu/link

        we.waitAndClick(rs.getBUDropDown());  // Wait for and click the Business Unit dropdown to expand options

        we.select(rs.getBUDropDown(), "BU3");  // Select "BU3" option from the Business Unit dropdown

        we.waitAndClick(rs.getEquipmentDropDown());  // Wait for and click the Equipment dropdown to expand

        we.waitAndClick(rs.getEquipmentCheckbox());  // Wait for and click the Equipment checkbox to select the equipment

        we.waitAndClick(rs.getFromDate());  // Wait for and click the "From Date" input field to activate it

        we.waitForElement(driver, rs.getFromDate());  // Wait explicitly until the From Date element is visible and interactable

        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();  // Clear any pre-filled date in the From Date input

        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");  // Enter the date "14-01-2025" in the From Date field

        we.waitAndClick(rs.getLinkDropDown());  // Wait for and click the Link dropdown to open options

        we.select(rs.getLinkDropDown(), "All");  // Select the "All" option from the Link dropdown

        we.waitAndClick(rs.getSearchButton());  // Wait for and click the Search button to apply filters and fetch results

        String expectedURL = "http://192.168.5.77:3000/downtime";  // Expected URL after navigation to the downtime page

        String actualURL = driver.getCurrentUrl();  // Get the current URL from the browser

        if (expectedURL.equals(actualURL)) {  // Compare expected and actual URLs
            System.out.println("Navigation to Downtime Reason Linking Page was successful.");  // Print success message if URLs match
        } else {
            System.out.println("Navigation failed. Current URL: " + actualURL);  // Print failure message with actual URL if mismatch
        }

    }

}