package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoleCreate {
	private WebDriver driver;

	// Constructor
	public RoleCreate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=\"Role\"]")
	private WebElement RolemoduleNavigation;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRolemoduleNavigation() {
		return RolemoduleNavigation;
	}

	public WebElement getAddRoleBtn() {
		return AddRoleBtn;
	}

	public WebElement getRoleNamefield() {
		return RoleNamefield;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	public WebElement getCancelButton() {
		return CancelButton;
	}

	public WebElement getSearchRolefield() {
		return SearchRolefield;
	}

	public WebElement getDots3Button() {
		return Dots3Button;
	}

	public WebElement getViewButton() {
		return ViewButton;
	}

	public WebElement getEditButton() {
		return EditButton;
	}

	public WebElement getChangeStatusButton() {
		return ChangeStatusButton;
	}

	public WebElement getDeleteButton() {
		return DeleteButton;
	}

	public WebElement getDowntimeCheckbox() {
		return DowntimeCheckbox;
	}

	@FindBy(xpath = "//button[text()=\"Add Roles\"]")
	private WebElement AddRoleBtn;
	
	@FindBy(xpath = "//input[@placeholder=\"Role Name\"]")
	private WebElement RoleNamefield;
	
	@FindBy(xpath = "//textarea[@placeholder=\"Description\"]")
	private WebElement Description;
	
	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement CancelButton;
	
	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement SearchRolefield;
	
	@FindBy(xpath = "//button[@aria-haspopup=\"true\"]")
	private WebElement Dots3Button;
	
	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement ViewButton;
	
	
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	private WebElement EditButton;
	
	@FindBy(xpath = "//a[contains(text(),' Change Status')]")
	private WebElement ChangeStatusButton;
	
	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	private WebElement DeleteButton;
	
	@FindBy(xpath = "//span[@class='rct-title' and text()='Downtime']/preceding-sibling::span[contains(@class,'rct-checkbox')]")
	private WebElement DowntimeCheckbox;
	

	@FindBy(xpath = "//span[@class='rct-title' and text()='Cycle Time']/preceding-sibling::span[contains(@class,'rct-checkbox')]")
	private WebElement CycletimeCheckbox;
	
	
	@FindBy(xpath = "//span[@class='rct-title' and text()='OEE']/preceding-sibling::span[contains(@class,'rct-checkbox')]")
	private WebElement OEECheckbox;
	
	@FindBy(xpath = "//button[text()=\"Yes\"]")
	private WebElement YesStatuschangesBtn;
	
	public WebElement getYesStatuschangesBtn() {
		return YesStatuschangesBtn;
	}

	public WebElement getNoStatuschangesBtn() {
		return NoStatuschangesBtn;
	}

	@FindBy(xpath = "//button[text()=\"No\"]")
	private WebElement NoStatuschangesBtn;
	
	
	public WebElement getNoDeleteBtn() {
		return NoDeleteBtn;
	}

	public WebElement getYesDeleteBtn() {
		return YesDeleteBtn;
	}

	@FindBy(xpath = "//button[text()=\"No\"]")
	private WebElement NoDeleteBtn;
	
	@FindBy(xpath = "//button[text()=\"Yes\"]")
	private WebElement YesDeleteBtn;

	public WebElement getOEECheckbox() {
		return OEECheckbox;
	}

	public WebElement getCycletimeCheckbox() {
		return CycletimeCheckbox;
	}
}


