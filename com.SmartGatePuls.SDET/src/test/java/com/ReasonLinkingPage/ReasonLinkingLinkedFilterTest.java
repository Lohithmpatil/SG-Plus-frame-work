package com.ReasonLinkingPage;  // Declares the package name for organizing classes related to Reason Linking page

import org.openqa.selenium.By;  // Imports Selenium's By class used for locating elements
import org.openqa.selenium.WebElement;  // Imports Selenium's WebElement class representing elements on the web page
import org.testng.annotations.Test;  // Imports TestNG annotation for marking test methods

import com.sgplus.erp.genericutility.BaseClass;  // Imports the BaseClass which includes setup and teardown for WebDriver
import com.sgplus.erp.genericutility.WebDriverUtility;  // Imports a utility class for common WebDriver operations
import com.sgplus.erp.pomRepository.HomePage;  // Imports the Page Object Model class for HomePage elements

public class ReasonLinkingLinkedFilterTest extends BaseClass {  // Defines the test class extending BaseClass for common setup/teardown

    @Test  // Marks this method as a TestNG test method
    public void ReasonLinkingLinkedFilterTest() throws InterruptedException {

        WebDriverUtility we = new WebDriverUtility();  // Creates instance of WebDriverUtility for reusable methods

        HomePage hm = new HomePage(driver);  // Initializes HomePage object to interact with homepage elements

        // Initializes ReasonLinking page object to interact with elements on Reason Linking page
        com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

        we.waitAndClick(hm.getDownTime());  // Waits for and clicks the "Downtime" link/menu on the HomePage

        we.waitAndClick(rs.getReasonLinking());  // Waits for and clicks the "Reason Linking" submenu/link

        we.waitAndClick(rs.getBUDropDown());  // Waits for and clicks the Business Unit (BU) dropdown to expand options

        we.select(rs.getBUDropDown(), "BU3");  // Selects the option "BU3" from the BU dropdown

        we.waitAndClick(rs.getEquipmentDropDown());  // Waits for and clicks the Equipment dropdown

        we.waitAndClick(rs.getEquipmentCheckbox());  // Waits for and clicks the Equipment checkbox to select equipment

        we.waitAndClick(rs.getFromDate());  // Waits for and clicks the "From Date" field to activate date input

        we.waitForElement(driver, rs.getFromDate());  // Explicitly waits for the From Date element to be present and interactable

        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();  // Clears any existing text in the From Date input field

        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");  // Inputs the date "14-01-2025" into the From Date field

        we.waitAndClick(rs.getLinkDropDown());  // Waits for and clicks the Link dropdown menu to open options

        we.select(rs.getLinkDropDown(), "Linked");  // Selects the "Linked" option from the Link dropdown menu

        we.waitAndClick(rs.getSearchButton());  // Waits for and clicks the Search button to apply filters and load results

        WebElement table = driver.findElement(By.id("expanded-table"));  // Locates the results table by its ID "expanded-table"

        if (table.isDisplayed()) {  // Checks if the results table is displayed on the page
            System.out.println("Linked data visible on the page");  // Prints confirmation if table is visible
        } else {
            System.out.println("Linked data is not visible");  // Prints warning if table is not visible
        }

    }
}