package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowntimeShiftview {
	WebDriver driver;

	public DowntimeShiftview(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=\"Shift View\"]")
	private WebElement ShiftviewDashboard;

	public WebElement getShiftviewDashboard() {
		return ShiftviewDashboard;
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

	@FindBy(xpath = "//select[@class='form-control' and @name='Equipment']/option[text()='SCPTBS01']")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//select[@class=\"form-control w-100\"]")
	private WebElement PeriodDropDown;

	@FindBy(xpath = "//label[text()='Shift ']/following-sibling::select")
	private WebElement ShiftDropDown;

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;
	
	@FindBy(xpath = "//span[text()=\"Downtime/Shift View\"]")
	private WebElement Headertext;

	public WebElement getHeadertext() {
		return Headertext;
	}

}
