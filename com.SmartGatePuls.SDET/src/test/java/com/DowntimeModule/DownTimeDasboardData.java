package com.DowntimeModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.LoginPage.java.copy.Loginpage;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class DownTimeDasboardData extends BaseClass {

	@Test
	public void DownTimeDasboardData() throws InterruptedException {

		WebDriverUtility we = new WebDriverUtility();
		Loginpage lp = new Loginpage();

		HomePage hm = new HomePage(driver);

		DowntiemDashboard dt = new DowntiemDashboard(driver);

		we.waitUntilPageLoad(driver);
		we.waitForElementInDOM(driver);

		// Wait for page to load
		we.waitAndClick(hm.getDownTime());

		// Open the down time dash board page
		we.waitAndClick(hm.getDowntimeDashboard());

		we.waitAndClick(dt.getFilterButton());

		we.waitAndClick(dt.getBUDropDown());

		we.select(dt.getBUDropDown(), "BU3");

		we.waitAndClick(dt.getAreaDropDown());

		we.select(dt.getAreaDropDown(), "TBM-PCR");

		we.waitAndClick(dt.getGroupDropDown());

		we.select(dt.getGroupDropDown(), "Unistage");

		we.waitAndClick(dt.getEquipementDropDown());

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();

		we.waitAndClick(dt.getPeriodDropDown());

		we.select(dt.getPeriodDropDown(), "Year");

		we.waitAndClick(dt.getShiftDropDown());

		we.select(dt.getShiftDropDown(), "All");

		we.waitAndClick(dt.getApplyFilter());
		
		// Verify Page Title
		String expectedTitle = "Downtime Dashboard";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Correct page title: " + actualTitle);
		} else {
			System.out.println("Title mismatch. Expected: " + expectedTitle + ", Found: " + actualTitle);
		}

		// Verify if Total Downtime is displayed
	WebElement totalDowntime = driver.findElement(By.xpath("//div[@class=\"align-self-center totalDowntime_totalDowntimeValue__1uE07\"]"));
		if (totalDowntime.isDisplayed()) {
			System.out.println("Total Downtime is displayed.");
		} else {
			System.out.println("Total Downtime is not displayed.");
		}

		// Verify if MTTR is displayed
		WebElement mttr = driver.findElement(By.xpath("//div[contains(text(),'MTTR')]"));
		if (mttr.isDisplayed()) {
			System.out.println("MTTR is displayed.");
		} else {
			System.out.println("MTTR is not displayed.");
		}

		// Verify if MTBF is displayed
		WebElement mtbf = driver.findElement(By.xpath("//div[contains(text(),'MTBF')]"));
		if (mttr.isDisplayed()) {
			System.out.println("MTBF is displayed.");
		} else {
			System.out.println("MTTR is not displayed.");
		}

	}
}
