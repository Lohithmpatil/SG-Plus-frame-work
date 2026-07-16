package com.AddAssociates;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.AddAssociates;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifyAddAssociatesBtn extends BaseClass {
	@Test
	public void VerifyAddAssociatesBtn() throws Throwable {

		// Create WebDriverUtility object for handling waits and actios
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		AddAssociates ad = new AddAssociates(driver);

		we.waitAndClick(hm.getSettings());

		we.waitAndClick(ad.getAddAssociatesPage());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(ad.getAddAssociatesBtn()));

		Assert.assertTrue(ad.getAddAssociatesBtn().isDisplayed());
		Assert.assertTrue(ad.getAddAssociatesBtn().isEnabled());

	}
}