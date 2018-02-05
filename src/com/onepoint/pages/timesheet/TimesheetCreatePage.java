package com.onepoint.pages.timesheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.utils.GenericUtilities;

public class TimesheetCreatePage {	
	WebDriver driver;
	
	@FindBy(linkText="Time Report")
	private WebElement timeReportHeader;
	
	@FindBy(id="EX_TIME_ADD_VW_EMPLID")
	private WebElement empId;
	
	@FindBy(id="EX_TIME_ADD_VW_PERIOD_END_DT")
	private WebElement periodEndDate;
	
	@FindBy(id="#ICSearch")
	private WebElement addButton;
	
	@FindBy(name="UniversalHeader")
	private WebElement universalFrame;
	
	@FindBy(name="TargetContent")
	private WebElement targetFrame;

	public TimesheetCreatePage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public boolean isTimesheetCreatePageLoaded(){
		boolean isHeaderDisplayed = false;
		try{
			isHeaderDisplayed = timeReportHeader.isDisplayed();
			return isHeaderDisplayed;
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
			return isHeaderDisplayed;
		}
	}
	
	public String getEmpId(){
		return empId.getAttribute("value");
	}
	
	public String getPeriodEndDate(){
		return periodEndDate.getAttribute("value");
	}
	
	public void switchToTargetFrame(){
		GenericUtilities.switchToFrame(driver, targetFrame);		
	}
}
