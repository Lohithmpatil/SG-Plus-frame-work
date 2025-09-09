package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowntiemDashboard {
	WebDriver driver;
	public DowntiemDashboard(WebDriver driver) {
	
		this. driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item']//span[text()='Dashboard']")
    private WebElement downtimeDashboard;
	
	public WebElement getDowntimeDashboard() {
		return downtimeDashboard;
	}

	public void setDowntimeDashboard(WebElement downtimeDashboard) {
		this.downtimeDashboard = downtimeDashboard;
	}

	public WebElement getFilterButton() {
		return FilterButton;
	}

	public void setFilterButton(WebElement filterButton) {
		FilterButton = filterButton;
	}

	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	public WebElement getAreaDropDown() {
		return AreaDropDown;
	}

	public void setAreaDropDown(WebElement areaDropDown) {
		AreaDropDown = areaDropDown;
	}

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	public void setGroupDropDown(WebElement groupDropDown) {
		GroupDropDown = groupDropDown;
	}

	public WebElement getEquipementDropDown() {
		return EquipementDropDown;
	}

	public void setEquipementDropDown(WebElement equipementDropDown) {
		EquipementDropDown = equipementDropDown;
	}

	public WebElement getPeriodDropDown() {
		return PeriodDropDown;
	}

	public void setPeriodDropDown(WebElement periodDropDown) {
		PeriodDropDown = periodDropDown;
	}

	@FindBy(xpath="//i[@class='fa fa-filter']")
	private WebElement FilterButton;
	
	@FindBy(xpath= "//select[@class=\"form-control\"]")
	private WebElement BUDropDown;
	
	@FindBy(xpath= "//select[@class=\"form-control  \"]")
	private WebElement AreaDropDown;
	
	@FindBy(xpath= "//select[@class='form-control ']")
	private WebElement GroupDropDown;
	
	@FindBy(xpath= "//div[@class=\"dropdown-heading-value\"]")
	private WebElement EquipementDropDown;
	
	@FindBy(xpath= "//select[@class=\"form-control w-100\"]")
	private WebElement PeriodDropDown;

	@FindBy(xpath= "//label[text()='Shift ']/following-sibling::select")
	private WebElement ShiftDropDown;
	
	
	@FindBy(xpath= "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;
	
	public WebElement getBestPerfomingMachine() {
		return BestPerfomingMachine;
	}

	@FindBy(xpath = "//div[contains(text(),'BEST PERFORMING MACHINES')]")
	private WebElement BestPerfomingMachine;
	
	public WebElement getApplyFilter() {
		return ApplyFilter;
	}

	public void setApplyFilter(WebElement applyFilter) {
		ApplyFilter = applyFilter;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getShiftDropDown() {
		return ShiftDropDown;
	}

	
}

