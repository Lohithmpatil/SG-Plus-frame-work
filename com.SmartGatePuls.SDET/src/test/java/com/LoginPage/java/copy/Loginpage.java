package com.LoginPage.java.copy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;

public class Loginpage {

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
		//driver.findElement(By.xpath("//select[@class=\"form-control custom-width\"]")).click();
		//Thread.sleep(4000);
		WebElement dropdown = driver
				.findElement(By.xpath("//select[@class=\"form-control custom-width\"]"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);

		Thread.sleep(4000);
		 //WebElement element=driver.findElement(By.xpath("//div[@class=\"dropdown-heading-value\"]"));
	

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
    	driver.findElement(By.xpath("//button[@title=\"Search\"]")).click();
    	
    	
    	
    	
    	
    	
    	
    	
	}
}