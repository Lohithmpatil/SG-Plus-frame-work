package com.ReasonLinkingPage;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class CheckDataPresentOnTable extends BaseClass {
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
		we.select(rs.getLinkDropDown(), "Unlinked");

		we.waitAndClick(rs.getSearchButton());

		WebElement table = driver.findElement(By.id("expanded-table"));
		if (table.isDisplayed()) {
			System.out.println("Table is visible on the page");
		} else {
			System.out.println("Table is not visible");
		}

	}

}
