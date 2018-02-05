package com.onepoint.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onepoint.config.TestData;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.pages.login.LoginPage;
import com.onepoint.pages.timesheet.TimesheetCreatePage;
import com.onepoint.utils.GenericUtilities;
import com.onepoint.utils.InitDriver;

public class TestTimesheetCreate extends InitDriver {
	@Test
	public void testTimesheetCreate(){
		Homepage homepage = new Homepage(driver);
		TimesheetCreatePage timesheetCreatePage = homepage.clickTimesheetCreateLink();
		timesheetCreatePage.switchToTargetFrame();
		String empId = timesheetCreatePage.getEmpId();
		Assert.assertEquals(empId, TestData.EXP_EMP_ID, "Employee Id did not match");
		String periodEndDate = timesheetCreatePage.getPeriodEndDate();
		Assert.assertEquals(periodEndDate, GenericUtilities.getCurrentSystemDate(), "Period End Date did not match");
	}
}
