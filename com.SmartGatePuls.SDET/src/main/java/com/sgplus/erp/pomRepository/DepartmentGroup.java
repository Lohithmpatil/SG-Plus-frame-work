package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentGroup {

	WebDriver driver;

	public DepartmentGroup(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=\"Group\"]")
	private WebElement Group;

	@FindBy(xpath = "//div[contains(text(),'Department Group created successfully')]")
	private WebElement successToast;

	public WebElement getSuccessToast() {
		return successToast;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getGroup() {
		return Group;
	}

	public WebElement getAddDepartmentGroup() {
		return AddDepartmentGroup;
	}

	public WebElement getSearchfield() {
		return Searchfield;
	}

	public WebElement getEditbutton() {
		return Editbutton;
	}

	public WebElement getGroupname() {
		return Groupname;
	}

	public WebElement getMTTRAandMTBFSorceButton() {
		return MTTRAandMTBFSorceButton;
	}

	public WebElement getAddButton() {
		return AddButton;
	}

	public WebElement getCloseButton() {
		return CloseButton;
	}

	@FindBy(xpath = "//button[text()=\"Add Department Group\"]")
	private WebElement AddDepartmentGroup;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement Searchfield;

	@FindBy(xpath = "//i[@title=\"Edit Name\"]")
	private WebElement Editbutton;

	@FindBy(xpath = "//input[@placeholder=\"Department Group Name\"]")
	private WebElement Groupname;

	@FindBy(xpath = "//input[@name=\"mttrmtbf\"]")
	private WebElement MTTRAandMTBFSorceButton;

	@FindBy(xpath = "//button[text()=\"Add\"]")
	private WebElement AddButton;

	@FindBy(xpath = "//button[text()=\"Close\"]")
	private WebElement CloseButton;

}
