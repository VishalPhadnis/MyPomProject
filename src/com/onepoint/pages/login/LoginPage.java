package com.onepoint.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onepoint.pages.homepage.Homepage;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath=".//*[@id='login']/div/img[@title='Oracle PeopleSoft Sign-in']")
	private WebElement onePointLogo;
	
	@FindBy (id="userid")
	private WebElement userId;
	
	@FindBy(id="pwd")
	private WebElement password;
	
	@FindBy(name="Submit")
	private WebElement SignInButton;
	
	public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public boolean isLoginPageLoaded(){
		boolean isLogoDisplayed = false;
		try{
		isLogoDisplayed = onePointLogo.isDisplayed();
		return isLogoDisplayed;
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
			return isLogoDisplayed;
		}
	}
	
	public void setUsername(String username){
		userId.sendKeys(username);
	}
	
	public void setPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public Homepage clickSignInButton() {
		SignInButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Homepage(driver);
	}
}
