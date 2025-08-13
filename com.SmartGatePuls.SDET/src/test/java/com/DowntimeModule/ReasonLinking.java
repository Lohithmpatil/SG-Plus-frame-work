package com.DowntimeModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.LoginPage.java.copy.Loginpage;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class ReasonLinking extends BaseClass {
	@Test
	public void Reasonlinkingpage() throws InterruptedException {

		WebDriverUtility we = new WebDriverUtility();
		Loginpage lp = new Loginpage();
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
		
String date=driver.findElement(By.xpath("//input[@class=\"form-control\"]")).getText();
System.out.println(date);
		we.waitAndClick(rs.getLinkDropDown());
		we.select(rs.getLinkDropDown(), "Linked");

		we.waitAndClick(rs.getSearchButton());

	}

}
