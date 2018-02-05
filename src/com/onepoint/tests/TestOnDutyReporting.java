package com.onepoint.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onepoint.pages.absence.OnDutyReportingPage;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.utils.InitDriver;

public class TestOnDutyReporting extends InitDriver {
	@Test
	public void testOnDutyReporting() {
		Homepage homepage = new Homepage(driver);
		OnDutyReportingPage onDutyReportingPage = homepage.clickOnDutyReportingLink();
		boolean isAlertDisplayed = onDutyReportingPage.isNotAutorizedPopupDisplayed();
		Assert.assertTrue(isAlertDisplayed, "Not Autorized alert is not Displayed");
		onDutyReportingPage.clickOkButton();
		driver.navigate().back();
		boolean isHomePageLoaded = homepage.isHomePageLoaded();
		Assert.assertTrue(isHomePageLoaded, "Homepage is not loaded");
	}
}
