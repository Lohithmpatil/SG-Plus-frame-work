package com.ReasonLinkingPage;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class NavigatetoReasonLinkingPage extends BaseClass {
	@Test
	public void Reasonlinkingpage() throws InterruptedException {

		WebDriverUtility we = new WebDriverUtility();

		HomePage hm = new HomePage(driver);
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		we.waitAndClick(hm.getDownTime());

		we.waitAndClick(rs.getReasonLinking());

		we.waitAndClick(rs.getBUDropDown());

		we.select(rs.getBUDropDown(), "BU3");

		we.waitAndClick(rs.getEquipemetsDropDown());

		we.waitAndClick(rs.getEqCheckBox());

		we.waitAndClick(rs.getFromDate());

		we.waitForElement(driver, rs.getFromDate());

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");

		we.waitAndClick(rs.getLinkDropDown());
		we.select(rs.getLinkDropDown(), "All");

		we.waitAndClick(rs.getSearchButton());

		String expectedURL = "http://sgp.smartiotsystem.com/downtime";
		String actualURL = driver.getCurrentUrl();
		if (expectedURL.equals(actualURL)) {
			System.out.println("Navigation to Downtime Reason Linking Page was successful.");
		} else {
			System.out.println("Navigation failed. Current URL: " + actualURL);
		}

	}

}
