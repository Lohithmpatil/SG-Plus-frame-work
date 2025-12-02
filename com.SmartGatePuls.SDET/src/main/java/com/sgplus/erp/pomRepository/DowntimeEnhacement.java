package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowntimeEnhacement {

	WebDriver driver;

	public DowntimeEnhacement(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Enhancement']")
	private WebElement EnhacementModule;

	public WebElement getEnhacementModule() {
		return EnhacementModule;
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

	public WebElement getCheckBoxEquipements() {
		return CheckBoxEquipements;
	}

	public WebElement getExportbutton() {
		return Exportbutton;
	}

	public WebElement getApplyFilter() {
		return ApplyFilter;
	}
	public WebElement getFilterButton() {
		return FilterButton;
	}

	@FindBy(xpath="//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	@FindBy(xpath = "//div[@aria-labelledby=\"Bu\"]")
	private WebElement BUDropDown;

	@FindBy(xpath = "//select[@class=\"form-control  \"]")
	private WebElement AreaDropDown;

	@FindBy(xpath = "//select[@class='form-control ']")
	private WebElement GroupDropDown;

	@FindBy(xpath = "//div[@class=\"dropdown-heading-value\"]")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement CheckBoxEquipements;

	@FindBy(xpath = "//button[@title=\"Export\"]")
	private WebElement Exportbutton;

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;

	@FindBy(xpath = "//div[@class=\"w-100  overflow-scroll mt-4\"]")
	private WebElement Table;
	
	@FindBy(xpath = "//span[text()=\"DOWNTIME DETAIL ENHANCEMENT\"]")
	private WebElement HeaderText;


	public WebElement getHeaderText() {
		return HeaderText;
	}

	public WebElement getTable() {
		return Table;
	}

}
