package com.aisera.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtils {

	public static void sendKeys(WebElement we, String text) {
		try {
			we.clear();
			we.sendKeys(text);

		} catch (RuntimeException e) {
			throw e;
		}

	}

	public static void click(WebElement we) {
		try {
			we.click();

		} catch (RuntimeException e) {
			throw e;
		}

	}

	public static boolean isSelected(WebElement we) {
		boolean isSelected = we.isSelected();
		return isSelected;
	}

	public static boolean isDisplayed(WebElement element) throws Exception {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			throw e;// Handle exceptions by assuming the element is not displayed
		}
	}



	public static void scrollIntoView(WebElement webElement, WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public static void maximizeWindow(WebDriver driver){
		driver.manage().window().maximize();

	}


}
