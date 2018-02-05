package com.onepoint.pages.timesheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TimesheetViewPage {
	WebDriver driver;

	public TimesheetViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
