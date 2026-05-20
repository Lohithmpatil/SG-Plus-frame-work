package com.AssociatePerformancereport;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEAssociatePerformancereoprtPage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class VerifytheAssociateperformancereportDropdown extends BaseClass{
	
	@Test
	public void VerifytheAssociateperformancereportDropdown() throws Throwable {
		// Initialize WebDriver utility for custom waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Initialize POM class for Home Page
		HomePage hm = new HomePage(driver);

		// Initialize POM class for Downtime Dashboard page
		OEEdashboard oe = new OEEdashboard(driver);
		// Navigate to "OEE " module via the homepage

		OEEAssociatePerformancereoprtPage aso = new OEEAssociatePerformancereoprtPage(driver);

		we.waitAndClick(hm.getOEE());

		we.waitAndClick(aso.getAssociatePerformancePage());

		// Wait for the 'Filter' button to be clickable and then click it
		we.waitAndClick(aso.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click it
		we.waitAndClick(aso.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(aso.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(aso.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown
		we.select(aso.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it
		we.waitAndClick(aso.getGroupDropDown());

		// Select "Unistage" from the Group dropdown
		we.select(aso.getGroupDropDown(), "Unistage");

		// Wait for the 'Group Dropdown' to be clickable and then click it
		we.waitAndClick(aso.getGroupDropDown());

		// Commented out code: Wait and select an Equipment dropdown option (not being
		// used)
		we.waitAndClick(aso.getEquipementDropDown());
		we.select(aso.getEquipementDropDown(), "All");

		we.waitAndClick(aso.getEquipementDropDown());

		// Clears any existing text in the "From Date" input field (ensuring clean

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement monthYear = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-datepicker-wrapper input")));

		monthYear.click();
		monthYear.sendKeys(Keys.CONTROL + "a");
		monthYear.sendKeys(Keys.DELETE);
		monthYear.sendKeys("04/2023");
		monthYear.sendKeys(Keys.ENTER);
		// Wait for the 'Apply Filter' button to be clickable and then click it
		we.waitAndClick(aso.getApplyFilter());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");
		
	we.waitAndClick(aso.getStatusdropdown());
	
	we.select(aso.getStatusdropdown(), "Gold");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));

		// Wait for rows
		wait1.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//table[contains(@class,'table-hover')]//tbody/tr")));

		List<WebElement> rows = driver.findElements(
		        By.xpath("//table[contains(@class,'table-hover')]//tbody/tr"));

		System.out.println("Total Rows : " + rows.size());

		for (int i = 0; i < rows.size(); i++)
		{
		    List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

		    System.out.println("===== ROW " + (i + 1) + " =====");

		    for (WebElement col : cols)
		    {
		        System.out.print(col.getText() + " | ");
		    }

		    System.out.println();
		}
		}

}

