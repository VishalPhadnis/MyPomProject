package com.onepoint.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onepoint.config.TestData;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.pages.login.LoginPage;
import com.onepoint.utils.InitDriver;

public class TestLoginPage extends InitDriver {
	@Test (enabled = false)
	public void testLoginPage(){
		LoginPage loginPage = new LoginPage(driver);
		boolean isLoginpageDisplayed = loginPage.isLoginPageLoaded();
		Assert.assertTrue(isLoginpageDisplayed, "Loginpage is not loaded");
		loginPage.setUsername(TestData.USER_NAME);
		loginPage.setPassword(TestData.PASSWORD);
		Homepage homePage = loginPage.clickSignInButton();
		boolean isHomePageLoaded = homePage.isHomePageLoaded();
		Assert.assertTrue(isHomePageLoaded, "Homepage is not loaded");
	}
}
