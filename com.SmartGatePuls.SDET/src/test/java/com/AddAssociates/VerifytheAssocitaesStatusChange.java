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

public class VerifytheAssocitaesStatusChange extends BaseClass {

	
	@Test
	public void VerifytheAssocitaesStatusChange() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		AddAssociates ad = new AddAssociates(driver);

		we.waitAndClick(hm.getSettings());

		we.waitAndClick(ad.getAddAssociatesPage());
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait2.until(ExpectedConditions.elementToBeClickable(ad.getStatusToggleBtn())).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[contains(@class,'Toastify__toast')]")));

		String actualMessage = successMsg.getText().trim();
		String expectedMessage = "Status updated successfully";

		Assert.assertEquals(actualMessage, expectedMessage,
		        "Success message is not matching.");
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until toast disappears
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.cssSelector(".Toastify__toast-body")));
}
}