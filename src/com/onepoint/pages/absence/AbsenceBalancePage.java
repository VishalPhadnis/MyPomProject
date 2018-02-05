package com.onepoint.pages.absence;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.utils.GenericUtilities;

public class AbsenceBalancePage {
	WebDriver driver;
	String viewAbsenceFrame = "ptifrmtgtframe";
		
	@FindBy(id="DERIVED_ABS_SS_TITLE_LONG")
	private WebElement viewAbsenceBalancesHeader;
	
	@FindBy(id="BALANCE$0")
	private WebElement sickLeaveBalance;
	
	@FindBy(id="BALANCE$1")
	private WebElement annualLeaveBalance;
	
	public AbsenceBalancePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public boolean isViewAbsenceBalancesPageLoaded(){
		boolean isHeaderDisplayed = false;
		try{
			isHeaderDisplayed = viewAbsenceBalancesHeader.isDisplayed();
		return isHeaderDisplayed;
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
			return isHeaderDisplayed;
		}
	}
	
	public void switchToAbsenceFrame(){
		GenericUtilities.switchToFrame(driver, viewAbsenceFrame);
	}
	
	public double getSickLeaveBalance() {
		String balance = sickLeaveBalance.getText().split(" ")[0];
		return Double.parseDouble(balance);
	}
	
	public double getAnnualLeaveBalance() {
		String balance = annualLeaveBalance.getText().split(" ")[0];
		return Double.parseDouble(balance);
	}
	
}
