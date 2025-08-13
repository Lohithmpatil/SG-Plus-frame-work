package com.sgplus.erp.pomRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
	
		this. driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDownTime() {
		return downTime;
	}

	public void setDownTime(WebElement downTime) {
		this.downTime = downTime;
	}

	public WebElement getDowntimeDashboard() {
		return downtimeDashboard;
	}

	public void setDowntimeDashboard(WebElement downtimeDashboard) {
		this.downtimeDashboard = downtimeDashboard;
	}

	@FindBy(css="[class=\"sidebarIcon activeSidebarIcon\"]")     //Rule 2 Identify all the elements using @find and @findBYs and @findAll
	private WebElement conditionalMontoring;
	
	@FindBy(xpath ="//span[text()='Downtime']")
	private WebElement downTime;
	
	@FindBy(xpath = "//li[@class='nav-item']//span[text()='Dashboard']")
    private WebElement downtimeDashboard;
	
	public WebElement getLogOut() {
		return LogOut;
	}



	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getConditionalMontoring() {
		return conditionalMontoring;
	}

	@FindBy(xpath = "//span[text()='Logout']")
    private WebElement LogOut;
	
	

	
}

	
