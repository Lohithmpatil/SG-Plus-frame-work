package com.sgplus.erp.pomRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage3 {
	WebDriver driver;
	public HomePage3(WebDriver driver) {
	
		this. driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(css="[class=\"sidebarIcon activeSidebarIcon\"]")     //Rule 2 Identify all the elements using @find and @findBYs and @findAll
	private WebElement conditionalMontoring;
	
	public WebElement getConditionalMontoring() {
		return conditionalMontoring;
	}

	public void setConditionalMontoring(WebElement conditionalMontoring) {
		this.conditionalMontoring = conditionalMontoring;
	}

	public WebElement getDownTime() {
		return downTime;
	}

	public void setDownTime(WebElement downTime) {
		this.downTime = downTime;
	}

	public WebElement getOee() {
		return oee;
	}

	public void setOee(WebElement oee) {
		this.oee = oee;
	}
	@FindBy(xpath ="div[@data-for=\"Downtime\"]")
	private WebElement downTime;
	
	@FindBy(xpath = "//div[@data-for=\"Oee\"]")
private WebElement oee;
	
	
	
}


