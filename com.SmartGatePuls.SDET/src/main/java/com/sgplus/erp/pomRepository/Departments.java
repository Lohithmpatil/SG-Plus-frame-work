package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Departments {
	WebDriver driver;

	public Departments(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDepartments() {
		return Departments;
	}

	public WebElement getAdddepartments() {
		return Adddepartments;
	}

	public WebElement getSearchdepartments() {
		return Searchdepartments;
	}

	public WebElement getViewbutton() {
		return Viewbutton;
	}

	public WebElement getEditbutton() {
		return Editbutton;
	}

	public WebElement getDepartmentNameField() {
		return DepartmentNameField;
	}

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	public WebElement getEquipemetsDropDown() {
		return EquipemetsDropDown;
	}

	public WebElement getDiscriptionfield() {
		return Discriptionfield;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	public WebElement getCancelButton() {
		return CancelButton;
	}

	@FindBy(xpath = "//span[text()=\"Department\"]")
	private WebElement Departments;

	@FindBy(xpath = "//button[text()=\"Add Departments\"]")
	private WebElement Adddepartments;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement Searchdepartments;

	@FindBy(xpath = "//a[text()=\" View\"]")
	private WebElement Viewbutton;

	@FindBy(xpath = "//a[text()=\" Edit\"]")
	private WebElement Editbutton;

	@FindBy(xpath = "//input[@placeholder=\"Department Name\"]")
	private WebElement DepartmentNameField;

	@FindBy(xpath = "//select[@name=\"groupId\"]")
	private WebElement GroupDropDown;

	@FindBy(xpath = "//div[@class=\"dropdown-heading-value\"]")
	private WebElement EquipemetsDropDown;

	@FindBy(xpath = "//textarea[@placeholder=\"Description\"]")
	private WebElement Discriptionfield;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement SubmitButton;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement CancelButton;
	
	@FindBy(xpath = "//body[@class=\"sidebar-icon-only\"]")
	private WebElement CheckBoxofEquipement;
	
	public WebElement getCheckBoxofEquipement() {
		return CheckBoxofEquipement;
	}

	public WebElement getArrowButton() {
		return ArrowButton;
	}

	@FindBy(css = "[class=\"dropdown-heading-dropdown-arrow gray\"]")
	private WebElement ArrowButton;
}
