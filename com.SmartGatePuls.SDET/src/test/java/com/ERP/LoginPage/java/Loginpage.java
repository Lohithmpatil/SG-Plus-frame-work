package com.ERP.LoginPage.java;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.LoginPage;

public class Loginpage extends BaseClass {

	@Test
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// WebDriver driver = new ChromeDriver();
		/*
		 * driver.get("http://sgp.smartiotsystem.com/login");
		 * driver.manage().window().maximize();
		 * driver.findElement(By.id("user_id")).sendKeys("superadmin");
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
		 * "admin@123");
		 * driver.findElement(By.xpath("//input[@class=\"button\"]")).click();
		 */

		// create a object in pom repository
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("superadmin", "admin@123");

	}

}
