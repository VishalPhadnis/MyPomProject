package com.onepoint.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.pages.absence.AbsenceBalancePage;
import com.onepoint.pages.absence.AbsenceRequestHistoryPage;
import com.onepoint.pages.absence.OnDutyReportingPage;
import com.onepoint.pages.timesheet.TimesheetCreatePage;
import com.onepoint.pages.timesheet.TimesheetModifyPage;
import com.onepoint.pages.timesheet.TimesheetViewPage;

public class Homepage {
	WebDriver driver;
	@FindBy(id="ptbr_header_container")
	private WebElement homepageHeader;
	
	@FindBy (linkText="On-Duty Reporting")
	private WebElement onDutyReportingLink;
	
	@FindBy (linkText="Absence Balances")
	private WebElement absenceBalancesLink;
	
	@FindBy (linkText="Absence Request History")
	private WebElement absenceRequestHistoryLink;
	
	@FindBy (linkText="Create")
	private WebElement timesheetCreateLink;
	
	@FindBy (linkText="Modify")
	private WebElement timesheetModifyLink;
	
	@FindBy (linkText="View")
	private WebElement timesheetViewLink;
	
	public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public boolean isHomePageLoaded(){
		boolean isHeaderDisplayed = false;
		try{
			isHeaderDisplayed = homepageHeader.isDisplayed();
			return isHeaderDisplayed;
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
			return isHeaderDisplayed;
		}
	}
	
	public AbsenceBalancePage clickAbsenceBalancesLink(){
		try {
			absenceBalancesLink.click();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		return new AbsenceBalancePage(driver);
	}
	
	public OnDutyReportingPage clickOnDutyReportingLink(){
		try {
			onDutyReportingLink.click();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		return new OnDutyReportingPage(driver);
	}
	
	public AbsenceRequestHistoryPage clickAbsenceRequestHistoryLink(){
		try {
			absenceRequestHistoryLink.click();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		return new AbsenceRequestHistoryPage(driver);
	}
	
	public TimesheetCreatePage clickTimesheetCreateLink(){
		try {
			timesheetCreateLink.click();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		return new TimesheetCreatePage(driver);
	}
	
	public TimesheetModifyPage clickTimesheetModifyLink(){
		try {
			timesheetModifyLink.click();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		return new TimesheetModifyPage(driver);
	}
	
	public TimesheetViewPage clickTimesheetViewLink(){
		try {
			timesheetViewLink.click();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		return new TimesheetViewPage(driver);
	}
}
