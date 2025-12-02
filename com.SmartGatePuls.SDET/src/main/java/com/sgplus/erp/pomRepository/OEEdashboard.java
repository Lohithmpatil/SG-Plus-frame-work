package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OEEdashboard {
	private WebDriver driver;

	// Constructor
	public OEEdashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements - identified using @FindBy
	@FindBy(xpath = "//li[@class='nav-item hover-open']//span[text()='Dashboard']")
	private WebElement OEEdashboard;

	public WebElement getOEEdashboard() {
		return OEEdashboard;
	}

	public WebElement getFilterButton() {
		return FilterButton;
	}

	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	public WebElement getAreaDropDown() {
		return AreaDropDown;
	}

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	public WebElement getEquipementDropDown() {
		return EquipementDropDown;
	}

	public WebElement getPeriodDropDown() {
		return PeriodDropDown;
	}

	public WebElement getShiftDropDown() {
		return ShiftDropDown;
	}

	public WebElement getApplyFilter() {
		return ApplyFilter;
	}

	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement BUDropDown;

	@FindBy(xpath = "//select[@class=\"form-control  \"]")
	private WebElement AreaDropDown;

	@FindBy(xpath = "//select[@class='form-control ']")
	private WebElement GroupDropDown;

	@FindBy(xpath = "//div[@class=\"dropdown-heading-value\"]")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//select[@class=\"form-control w-100\"]")
	private WebElement PeriodDropDown;

	@FindBy(xpath = "//label[text()='Shift ']/following-sibling::select")
	private WebElement ShiftDropDown;

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;

	@FindBy(xpath = "//div[@class=\"fs-4 fw-semibold \"]")
	private WebElement OeeData;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAvailabilityData() {
		return AvailabilityData;
	}

	@FindBy(xpath = "//div[@class=\"fs-4 fw-semibold \"]")
	private WebElement AvailabilityData;

	public WebElement getOeeData() {
		return OeeData;
	}

	public WebElement getQualityData() {
		return QualityData;
	}

	public WebElement getPerformanceData() {
		return PerformanceData;
	}

	@FindBy(xpath = "//div[@class=\"fs-4 fw-semibold \"]")
	private WebElement QualityData;

	@FindBy(xpath = "//div[@class=\"fs-4 fw-semibold \"]")
	private WebElement PerformanceData;

	public WebElement getNoOfEuipemntButton() {
		return NoOfEuipemntButton;
	}

	@FindBy(xpath = "//td[@style=\"text-decoration: underline; color: blue; cursor: pointer; text-align: center;\"]")
	private WebElement NoOfEuipemntButton;
	
	public WebElement getVeiwDetailsToggleButton() {
		return VeiwDetailsToggleButton;
	}

	@FindBy(xpath = "//label[@for='custom-switch']")
	private WebElement VeiwDetailsToggleButton;
	
	public WebElement getEquipemntCheckBox() {
		return EquipemntCheckBox;
	}

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement EquipemntCheckBox;
	
	@FindBy(xpath = "//div[@class='legend-class']")
	private WebElement Legends;

	public WebElement getLegends() {
		return Legends;
	}
}
	

