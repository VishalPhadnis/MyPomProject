package com.onepoint.pages.absence;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.utils.GenericUtilities;

public class OnDutyReportingPage {
	WebDriver driver;
	
	@FindBy (id="ptModTable_0")
	private WebElement notAutorizedPopup;
	
	@FindBy (xpath="//span[@class='popupText']")
	private WebElement popupMessage;
	
	@FindBy (id="#ICOK")
	private WebElement okButton;
	
	public OnDutyReportingPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public boolean isNotAutorizedPopupDisplayed() {
		boolean isPopupDisplayed = false;
		try{
			isPopupDisplayed = notAutorizedPopup.isDisplayed();
		return isPopupDisplayed;
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
			return isPopupDisplayed;
		}
	}
	
	public String getPopupMessage(){
		try{
			return GenericUtilities.getAlertPopupMessage(driver);
		} catch (NoAlertPresentException  e){
			System.out.println("Error....." + e.getMessage());
			return null;
		}
	}
	
	public void clickOkButton(){
		okButton.click();
	}

}
