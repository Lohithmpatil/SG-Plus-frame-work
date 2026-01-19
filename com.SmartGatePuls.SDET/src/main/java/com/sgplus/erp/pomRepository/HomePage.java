package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements - identified using @FindBy
    @FindBy(css = ".sidebarIcon.activeSidebarIcon")
    private WebElement conditionalMonitoring;

    @FindBy(xpath = "//span[text()='Downtime']")
    private WebElement downTime;

    @FindBy(xpath = "//li[@class='nav-item']//span[text()='Dashboard']")
    private WebElement downtimeDashboard;

    @FindBy(xpath = "//span[text()='Logout']")
    private WebElement logOut;
    
    public WebElement getSettings() {
		return Settings;
	}

	@FindBy(xpath = "//span[text()=\"Settings\"]")
    private WebElement Settings;

    
    public WebElement getOEE() {
		return OEE;
	}

	@FindBy(xpath = "//span[text()=\"OEE\"]")
    private WebElement OEE;


    // Getters
    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getConditionalMonitoring() {
        return conditionalMonitoring;
    }

    public WebElement getDownTime() {
        return downTime;
    }

    public WebElement getDowntimeDashboard() {
        return downtimeDashboard;
    }

    public WebElement getLogOut() {
        return logOut;
    }

    // Setters (optional, but generally not needed for WebElements)
    public void setDownTime(WebElement downTime) {
        this.downTime = downTime;
    }

    public void setDowntimeDashboard(WebElement downtimeDashboard) {
        this.downtimeDashboard = downtimeDashboard;
    }

}