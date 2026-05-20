package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OEEAssociatePerformancereoprtPage {

	WebDriver driver;

	public OEEAssociatePerformancereoprtPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAssociatePerformancePage() {
		return AssociatePerformancePage;
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

	@FindBy(xpath = "//span[text()='Performance']")
	private WebElement AssociatePerformancePage;
	
	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement BUDropDown;

	@FindBy(xpath = "//select[@class=\"form-control  \"]")
	private WebElement AreaDropDown;

	@FindBy(xpath = "//select[@class='form-control ']")
	private WebElement GroupDropDown;

	@FindBy(xpath = "//label[normalize-space()='Equipment']/following::select[1]")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//div[@class=\"react-datepicker-wrapper\"]")
	private WebElement PeriodDropDown;

	@FindBy(xpath = "//label[text()='Shift ']/following-sibling::select")
	private WebElement ShiftDropDown;

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;
	
	public WebElement getStatusdropdown() {
		return statusdropdown;
	}

	@FindBy(xpath = "//div[@class=\" css-1xc3v61-indicatorContainer\"]")
	private WebElement statusdropdown;
	
	@FindBy(xpath = "//button[@title=\"Export\"]")
	private WebElement Exportbutton;

	public WebElement getExportbutton() {
		return Exportbutton;
	}
	
}
