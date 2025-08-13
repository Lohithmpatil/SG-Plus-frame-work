package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class LoginPage { // Fixed the class name

	WebDriver driver;

	// Constructor for initializing WebDriver and PageFactory elements
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize the elements
	}

	// Web elements on the Login Page
	@FindBy(id = "user_id")
	private WebElement userNameEdt;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordEdt;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement logInBtn;

	// Getters for elements (optional)
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}

	public void logintoApp(String username, String password) {
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		logInBtn.click();
	}
}