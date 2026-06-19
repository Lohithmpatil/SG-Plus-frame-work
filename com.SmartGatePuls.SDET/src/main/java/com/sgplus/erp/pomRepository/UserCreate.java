package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCreate {
	private WebDriver driver;

	// Constructor
	public UserCreate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsermodule() {
		return usermodule;
	}

	public WebElement getSearchhfield() {
		return searchhfield;
	}

	public WebElement getAdduserbutton() {
		return Adduserbutton;
	}

	public WebElement getNamefield() {
		return Namefield;
	}

	public WebElement getUserID() {
		return userID;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getMobileno() {
		return Mobileno;
	}

	public WebElement getRoledropdown() {
		return roledropdown;
	}

	@FindBy(xpath = "//span[text()='User']")
	private WebElement usermodule;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement searchhfield;

	@FindBy(xpath = "//button[text()=\"Add Users\"]")
	private WebElement Adduserbutton;

	@FindBy(xpath = "//input[@placeholder=\"Name\"]")
	private WebElement Namefield;

	@FindBy(xpath = "//input[@placeholder=\"User Name\"]")
	private WebElement userID;

	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement password;

	@FindBy(xpath = "//input[@placeholder=\"User Name\"]")
	private WebElement user;

	@FindBy(xpath = "//input[@name=\"mobileNumber\"]")
	private WebElement Mobileno;

	@FindBy(xpath = "//select[@name=\"roleId\"]")
	private WebElement roledropdown;

	public WebElement getEmailId() {
		return emailId;
	}

	@FindBy(xpath = "//input[@name=\"emailId\"]")
	private WebElement emailId;

	@FindBy(xpath = "//label[contains(.,'Plant A')]//input[@type='checkbox']")
	private WebElement PlantAcheckbox;

	public WebElement getPlantAcheckbox() {
		return PlantAcheckbox;
	}

	public WebElement getBU1checkbox() {
		return BU1checkbox;
	}

	@FindBy(xpath = "//label[contains(.,'BU1')]//input[@type='checkbox']")
	private WebElement BU1checkbox;
	
	public WebElement getBU2checkbox() {
		return BU2checkbox;
	}

	@FindBy(xpath = "//label[contains(.,'BU2')]//input[@type='checkbox']")
	private WebElement BU2checkbox;

	
	@FindBy(xpath = "//label[contains(.,'Mixing')]//input[@type='checkbox']")
	private WebElement MixingAreaCheckbox;
	
	public WebElement getMixingAreaCheckbox() {
		return MixingAreaCheckbox;
	}

	public WebElement getFinalMixerboxGroupCheckbox() {
		return FinalMixerboxGroupCheckbox;
	}

	public WebElement getMixerEquipementCheckCheckbox() {
		return MixerEquipementCheckCheckbox;
	}

	@FindBy(xpath = "//label[contains(.,'Final Mixer')]//input[@type='checkbox']")
	private WebElement FinalMixerboxGroupCheckbox;
	
	@FindBy(xpath = "//label[contains(.,'Mixer001')]//input[@type='checkbox']")
	private WebElement MixerEquipementCheckCheckbox;
	
	

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submitbutton;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement cancelbutton;

	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement viewButton;

	@FindBy(xpath = "//button[@aria-haspopup=\"true\"]")
	private WebElement dots3;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement EditButton;
	



	public WebElement getEditButton() {
		return EditButton;
	}

	public WebElement getResetPasswordButton() {
		return ResetPasswordButton;
	}

	public WebElement getChnageStatusButton() {
		return ChnageStatusButton;
	}

	public WebElement getDeleteBitton() {
		return DeleteBitton;
	}

	public WebElement getEnterNewPassword() {
		return EnterNewPassword;
	}

	public WebElement getOKNewPasswordButton() {
		return OKNewPasswordButton;
	}

	public WebElement getCancelNewPasswordButton() {
		return CancelNewPasswordButton;
	}

	public WebElement getYesStatusChangeButton() {
		return YesStatusChangeButton;
	}

	public WebElement getNOStatusChangeButton() {
		return NOStatusChangeButton;
	}

	@FindBy(xpath = "//a[normalize-space()='Reset Password']")
	private WebElement ResetPasswordButton;

	@FindBy(xpath = "//a[normalize-space()='Change Status']")
	private WebElement ChnageStatusButton;

	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement DeleteBitton;

	@FindBy(xpath = "//input[@placeholder=\"Enter New Password\"]")
	private WebElement EnterNewPassword;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement OKNewPasswordButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement CancelNewPasswordButton;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement YesStatusChangeButton;

	@FindBy(xpath = "//button[text()='No']")
	private WebElement NOStatusChangeButton;
	
	@FindBy(xpath = "//button[text()=\"Yes\"]")
	private WebElement DeleteYesButton;
	
	public WebElement getDeleteYesButton() {
		return DeleteYesButton;
	}

	public WebElement getDeleteNoButton() {
		return DeleteNoButton;
	}

	@FindBy(xpath = "//button[text()=\"No\"]")
	private WebElement DeleteNoButton;
	
	

	public WebElement getDots3() {
		return dots3;
	}

	public WebElement getViewButton() {
		return viewButton;
	}

}
