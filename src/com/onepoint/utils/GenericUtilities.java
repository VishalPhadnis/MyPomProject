package com.onepoint.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtilities {
	//protected WebDriver driver;
	
	public static void switchToFrame(WebDriver driver, String id) {
		try {
			driver.switchTo().frame(id);
		} catch (Exception e){
			System.out.println("Error....." + e.getMessage());
		}		
	}
	
	public static void switchToFrame(WebDriver driver, WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e){
			System.out.println("Error....." + e.getMessage());
		}		
	}
	
	public static void switchToFrame(WebDriver driver, int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e){
			System.out.println("Error....." + e.getMessage());
		}		
	}
	
	public static void switchToMultipleFrame(WebDriver driver, int frameCount) {
		try {
			for (int i=0; i<frameCount; i++)
			driver = driver.switchTo().frame(i);
		} catch (Exception e){
			System.out.println("Error....." + e.getMessage());
		}		
	} 
	
	public static void switchToDefaultWindow(WebDriver driver){
		driver.switchTo().defaultContent();
	}
	
	public static void acceptAlertPopup(WebDriver driver){
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException  e){
			System.out.println("Error....." + e.getMessage());
		}
	}
	
	public static void dismissAlertPopup(WebDriver driver){
		try{
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException  e){
			System.out.println("Error....." + e.getMessage());
		}
	}
	
	public static String getAlertPopupMessage(WebDriver driver){
		try{
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException  e){
			System.out.println("Error....." + e.getMessage());
			return null;
		}
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		Point location = element.getLocation();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,"+location.y+")");
	}
	
	public static void javascriptExecutorClick(WebDriver driver, WebElement element) {
		try {
			if(element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguements[0].click(, arg1);", element);
			} 
		} catch (Exception e) {
				System.out.println("Error....." + e.getMessage());
			}
		}
	
	public static String getCurrentSystemDate(){
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
	    Date dateobj = new Date();
	    return df.format(dateobj);
	}
}
