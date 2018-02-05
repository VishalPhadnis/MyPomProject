package com.onepoint.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onepoint.config.TestData;
import com.onepoint.pages.absence.AbsenceBalancePage;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.pages.login.LoginPage;
import com.onepoint.utils.InitDriver;

public class TestAbsenceBalance extends InitDriver {
	@Test
	public void testAbsenceBalance() {		
		Homepage homePage = new Homepage(driver);
		boolean isHomePageLoaded = homePage.isHomePageLoaded();
		Assert.assertTrue(isHomePageLoaded, "Homepage is not loaded");
		AbsenceBalancePage absenceBalancePage = homePage.clickAbsenceBalancesLink();
		absenceBalancePage.switchToAbsenceFrame();
		boolean isViewAbsenceBalancesPageLoaded = absenceBalancePage.isViewAbsenceBalancesPageLoaded();
		Assert.assertTrue(isViewAbsenceBalancesPageLoaded, "View Absence Balances Page is not loaded");
		Double sickLeaveBalance = absenceBalancePage.getSickLeaveBalance();//2.00 Days
		Assert.assertEquals(sickLeaveBalance, TestData.EXP_SICK_LEAVE_BALANCE, "Sick leave balance did not match");
		Double annualLeaveBalance = absenceBalancePage.getAnnualLeaveBalance();
		Assert.assertEquals(annualLeaveBalance, TestData.EXP_ANNUAL_LEAVE_BALANCE, "Annual leave balance did not match");
	}
}
