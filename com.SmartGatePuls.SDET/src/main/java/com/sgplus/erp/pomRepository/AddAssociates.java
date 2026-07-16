package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAssociates {

	private WebDriver driver;

	// Constructor
	public AddAssociates(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* ================= DASHBOARD ================= */

// WebElements - identified using @FindBy
	@FindBy(xpath = "//span[text()=\"Add Associates\"]")
	private WebElement AddAssociatesPage;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddAssociatesPage() {
		return AddAssociatesPage;
	}

	public WebElement getAddAssociatesBtn() {
		return AddAssociatesBtn;
	}

	public WebElement getAddAssociatesNameField() {
		return AddAssociatesNameField;
	}

	public WebElement getSapcodeField() {
		return SapcodeField;
	}

	public WebElement getMobieNoField() {
		return MobieNoField;
	}

	public WebElement getAreaDropdown() {
		return AreaDropdown;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getSearchfield() {
		return Searchfield;
	}

	public WebElement getStatusToggleBtn() {
		return StatusToggleBtn;
	}

	public WebElement getDots3Btn() {
		return Dots3Btn;
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}

	@FindBy(xpath = "//button[text()='Add Associate']")
	private WebElement AddAssociatesBtn;

	@FindBy(xpath = "//input[@placeholder=\"Enter Name\"]")
	private WebElement AddAssociatesNameField;

	@FindBy(xpath = "//input[@placeholder=\"Enter Sap Code\"]")
	private WebElement SapcodeField;

	@FindBy(xpath = "//input[@placeholder=\"Enter Mobile\"]")
	private WebElement MobieNoField;

	@FindBy(xpath = "//div[@class=\"dropdown-heading\"]")
	private WebElement AreaDropdown;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement CancelBtn;

	@FindBy(xpath = "//input[@placeholder=\"Search by Name, Sap Code\"]")
	private WebElement Searchfield;

	@FindBy(xpath = "//label[@for=\"custom-switch-1868\"]")
	private WebElement StatusToggleBtn;

	@FindBy(xpath = "//button[@aria-haspopup=\"true\"]")
	private WebElement Dots3Btn;

	@FindBy(xpath = "//a[@class=\"pl-3 dropdown-item\"]")
	private WebElement EditBtn;

	
	@FindBy(xpath = "//label[contains(.,'Select All')]//input[@type='checkbox']")
	private WebElement AreaCheckBox;
	
	public WebElement getAreaCheckBox() {
		return AreaCheckBox;
	}

	public WebElement getCollapseAreadropdown() {
		return CollapseAreadropdown;
	}

	public WebElement getUdanNO() {
		return UdanNO;
	}

	@FindBy(xpath = "//div[@class=\"dropdown-heading-value\"]")
	private WebElement CollapseAreadropdown;
	
	@FindBy(xpath = "//input[@name=\"udaan_no\"]")
	private WebElement UdanNO;
}
