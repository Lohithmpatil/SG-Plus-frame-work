package com.LoginPage.java.copy;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;

public class Practice {

	@Test
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://sgp.smartiotsystem.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_id")).sendKeys("superadmin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//input[@class=\"button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Downtime']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Reason']")).click();
		Thread.sleep(4000);
		// driver.findElement(By.xpath("//select[@class=\"form-control
		// custom-width\"]")).click();
		// Thread.sleep(4000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@class=\"form-control custom-width\"]"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);

		Thread.sleep(4000);
		// WebElement
		// element=driver.findElement(By.xpath("//div[@class=\"dropdown-heading-value\"]"));

		// Create an Actions instance
		// Actions actions = new Actions(driver);

		// Perform the mouse hover action
		// actions.moveToElement(element).perform();

		driver.findElement(By.xpath("//div[@class=\"dropdown-heading-value\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).click();

		Thread.sleep(4000);

		WebElement fromDateInput = driver.findElement(By.xpath("//input[@id='formGridFromDate']"));
		fromDateInput.click();

		Thread.sleep(4000);
		// Navigate to the previous month
		WebElement calendarField = driver.findElement(By.xpath("//input[contains(@id,'formGridFromDate')]"));
		calendarField.clear();
		calendarField.sendKeys("14-01-2025");

		Thread.sleep(4000);

		WebElement dropdown1 = driver.findElement(By.xpath("//select[@class=\"form-control custom-width ml-0\"]"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(2);

		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@title=\"Search\"]")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class=\"text-center reason-action-cell\"]")).click();
		// Thread.sleep(4000);
		// Wait until modal is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formReasonId")));

		// Select Department Group
		WebElement deptGroup = driver.findElement(By.id("formReasonId"));
		Select selectDept = new Select(deptGroup);
		selectDept.selectByIndex(1);
		Thread.sleep(4000);
		// Select Department
		WebElement dept = driver.findElement(By.name("dept_id"));
		Select selectDept2 = new Select(dept);
		selectDept2.selectByIndex(2);
		Thread.sleep(4000);

		WebElement Reason = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));

		Select selectReason = new Select(Reason);
		selectDept2.selectByIndex(2);

		Thread.sleep(4000);

		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Automation test reason");
		Thread.sleep(4000);
		// Click Save button
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}
}