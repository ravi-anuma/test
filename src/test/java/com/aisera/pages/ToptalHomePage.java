package com.aisera.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToptalHomePage {

    private WebDriver driver;

    public ToptalHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getApplyAsFreelancerLink() {
        return driver.findElement(By.linkText("Apply as Freelancer"));
    }

}
