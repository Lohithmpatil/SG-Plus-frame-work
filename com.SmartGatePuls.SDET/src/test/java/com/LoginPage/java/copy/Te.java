package com.LoginPage.java.copy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class Te extends BaseClass {
	@Test
	public void Homepage() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("http://sgp.smartiotsystem.com/login");
		driver.manage().window().maximize();

		// Perform login
		driver.findElement(By.id("user_id")).sendKeys("superadmin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		Thread.sleep(5000);

		// Navigate to Downtime/Reason
		driver.findElement(By.xpath("//span[text()='Downtime']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Reason']")).click();
		Thread.sleep(4000);

		// Interact with the Area dropdown (select element)
		WebElement areaDropdown = driver.findElement(By.xpath("//select[@class='form-control custom-width']"));
		Select areaSelect = new Select(areaDropdown);

		// Select an option by visible text (e.g., "BU3")
		areaSelect.selectByVisibleText("BU3");
		Thread.sleep(4000);

		// Deselect by index (if it's a multi-select dropdown)
		areaSelect.deselectByIndex(3); // If needed, for multi-select dropdowns
		Thread.sleep(4000);

		// Select another option from the Area dropdown
		areaSelect.selectByVisibleText("TBM-PCR");
		Thread.sleep(3000);

	}
}