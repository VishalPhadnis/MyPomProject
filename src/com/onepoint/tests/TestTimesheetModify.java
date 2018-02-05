package com.onepoint.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onepoint.config.TestData;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.pages.login.LoginPage;
import com.onepoint.pages.timesheet.TimesheetCreatePage;
import com.onepoint.pages.timesheet.TimesheetModifyPage;
import com.onepoint.utils.GenericUtilities;
import com.onepoint.utils.InitDriver;

public class TestTimesheetModify extends InitDriver {
	@Test
	public void testTimesheetCreate(){
		Homepage homepage = new Homepage(driver);
		TimesheetModifyPage timesheetModifyPage = homepage.clickTimesheetModifyLink();
		timesheetModifyPage.switchToTargetFrame();
		
	}
}
