package com.onepoint.pages.timesheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.utils.GenericUtilities;

public class TimesheetModifyPage {
	WebDriver driver;
		
	@FindBy(linkText="Time Report")
	private WebElement timeReportHeader;
	
	@FindBy(id="ptifrmtgtframe")
	private WebElement targetFrame;
	
	@FindBy(id="srchInstructions")
	private WebElement searchInstructions;
	
	public TimesheetModifyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void switchToTargetFrame(){
		GenericUtilities.switchToFrame(driver, targetFrame);		
	}
	
}
