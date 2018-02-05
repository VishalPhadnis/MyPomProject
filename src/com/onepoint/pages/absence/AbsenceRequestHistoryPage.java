package com.onepoint.pages.absence;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.utils.GenericUtilities;

public class AbsenceRequestHistoryPage {
	WebDriver driver;
	String viewAbsenceHistoryFrame = "ptifrmtgtframe";
	
	@FindBy(id="DERIVED_ABS_SS_TITLE_LONG")
	private WebElement viewAbsenceHistoryHeader;
	
	@FindBy(xpath=".//table[@id='tdgbrGP_ABSHISTSS_VW$0']/tbody/tr")
	private List<WebElement> listOfAbsenceRequests;
	
	@FindBy(xpath="//a[contains(text(),'Annual Leave')]")
	private List<WebElement> listOfAnnualLeaveRequests;
	
	@FindBy(xpath="//a[contains(text(),'Sick Leave')]")
	private List<WebElement> listOfSickLeaveRequests;

	public AbsenceRequestHistoryPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void switchToAbsenceRequestHistoryFrame(){
		GenericUtilities.switchToFrame(driver, viewAbsenceHistoryFrame);
	}
	
	public boolean isViewAbsenceHistoryPageLoaded(){
		boolean isHistoryDisplayed = false;
		try{
			isHistoryDisplayed = viewAbsenceHistoryHeader.isDisplayed();
			return isHistoryDisplayed;
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
			return isHistoryDisplayed;
		}
	}
	
	public int noOfAbsenceRequests(){
		//List<WebElement> absenceRequests = driver.findElements(By.xpath(".//table[@id='tdgbrGP_ABSHISTSS_VW$0']/tbody/tr"));
		return listOfAbsenceRequests.size();
	}
	
	public int getNumOfAnnualLeaveRequests(){
		int count = 0;
		try {
			count = listOfAnnualLeaveRequests.size();
			return count;
		} catch (Exception e){
			System.out.println("Error....." + e.getMessage());
			return count;
		}
	}
	
	public int getNumOfSickLeaveRequests(){
		int count = 0;
		try {
			count = listOfSickLeaveRequests.size();
			return count;
		} catch (Exception e){
			System.out.println("Error....." + e.getMessage());
			return count;
		}
	}

}
