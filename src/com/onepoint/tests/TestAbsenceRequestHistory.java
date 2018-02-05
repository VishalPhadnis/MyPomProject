package com.onepoint.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.onepoint.config.TestData;
import com.onepoint.pages.absence.AbsenceBalancePage;
import com.onepoint.pages.absence.AbsenceRequestHistoryPage;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.pages.login.LoginPage;
import com.onepoint.utils.InitDriver;

public class TestAbsenceRequestHistory extends InitDriver {
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void testAbsenceRequestHistory() {		
		Homepage homePage = new Homepage(driver);
		boolean isHomePageLoaded = homePage.isHomePageLoaded();
		Assert.assertTrue(isHomePageLoaded, "Homepage is not loaded");
		AbsenceRequestHistoryPage absenceRequestHistoryPage = homePage.clickAbsenceRequestHistoryLink();
		absenceRequestHistoryPage.switchToAbsenceRequestHistoryFrame();
		boolean isViewAbsenceBalancesPageLoaded = absenceRequestHistoryPage.isViewAbsenceHistoryPageLoaded();
		Assert.assertTrue(isViewAbsenceBalancesPageLoaded, "View Absence Balances Page is not loaded");
		int sickLeaveRequests = absenceRequestHistoryPage.getNumOfSickLeaveRequests();
		softAssert.assertEquals(sickLeaveRequests, TestData.EXP_SICK_LEAVE_REQUESTS, "No. of Sick leave requests did not match");
		//Assert.assertEquals(sickLeaveRequests, TestData.EXP_SICK_LEAVE_REQUESTS, "No. of Sick leave requests did not match");
		int annualLeaveRequests = absenceRequestHistoryPage.getNumOfAnnualLeaveRequests();
		//Assert.assertEquals(annualLeaveRequests, TestData.EXP_ANNUAL_LEAVE_REQUESTS, "No. of Annual leave balance did not match");
		softAssert.assertEquals(annualLeaveRequests, TestData.EXP_ANNUAL_LEAVE_REQUESTS, "No. of Annual leave balance did not match");
		softAssert.assertAll();
	}
}
