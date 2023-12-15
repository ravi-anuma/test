package com.aisera.pages;

import com.aisera.util.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToptalApplyPage {

    private WebDriver driver;

    public ToptalApplyPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTypeDropdown() {
        return driver.findElement(By.name("talentType"));
    }

    public WebElement getFullNameInput() {
        return driver.findElement(By.xpath("//input[@name='fullName']"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.xpath("//input[@name='email']"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void fillForm(String fullName, String email, String password) throws Exception {
        // Handle Cookie Policy overlay
        WebElement cookieOverlay = driver.findElement(By.id("ccc-revamp-modal"));
        if (DriverUtils.isDisplayed(cookieOverlay)) {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(),'Accept Cookies')]"));
            DriverUtils.click(acceptCookiesButton);
        }

        // Scroll elements into view if necessary
        DriverUtils.scrollIntoView(getFullNameInput(), driver);

        // Fill in form fields
        DriverUtils.sendKeys(getFullNameInput(), fullName);
        DriverUtils.sendKeys(getEmailInput(), email);
        DriverUtils.sendKeys(getPasswordInput(), password);

        // Scroll elements into view
        DriverUtils.scrollIntoView(getSubmitButton(), driver);
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }
}
