package com.AddAssociates;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.AddAssociates;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifytheAddAssociatesPageTitle extends BaseClass {

	@Test
	public void VerifytheAddAssociatesPageNavigation() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		AddAssociates ad = new AddAssociates(driver);

		we.waitAndClick(hm.getSettings());

		we.waitAndClick(ad.getAddAssociatesPage());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement pageTitle = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Settings/Add Associate']")));

		Assert.assertEquals(pageTitle.getText(), "Settings/Add Associate");
	}
}