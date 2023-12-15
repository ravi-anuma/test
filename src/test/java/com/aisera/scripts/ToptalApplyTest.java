package com.aisera.scripts;

import com.aisera.pages.ToptalApplyPage;
import com.aisera.pages.ToptalHomePage;
import com.aisera.util.ConfigFileReader;
import com.aisera.util.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ToptalApplyTest {

    private WebDriver driver;
    private ToptalHomePage homePage;
    private ToptalApplyPage applyPage;

    private ConfigFileReader configFileReader = new ConfigFileReader();

    public ToptalApplyTest() throws IOException {
    }

    @BeforeMethod
    public void setUp() {
        // Setup WebDriver using WebDriver Manager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePage = new ToptalHomePage(driver);
        applyPage = new ToptalApplyPage(driver);

        DriverUtils.maximizeWindow(driver);
        driver.get(configFileReader.getUrl());
    }

    @Test(description = "Verify page contains the link Apply as Freelancer Link", priority = 1)
    public void verifyApplyFreelancerLinkInHomepage() throws Exception {
        // Step 2.1: Confirm that the page contains the link "Apply as Freelancer"
        WebElement webElement = homePage.getApplyAsFreelancerLink();
        boolean applyFlLinkIsDisplay = DriverUtils.isDisplayed(webElement);
        Assert.assertTrue(applyFlLinkIsDisplay, "Apply as Freelancer Link is not Available in Webpage");

    }

    @Test(description = "Verify fill form to apply to join Toptal portal", priority = 2)
    public void fillFormForApplyToJoinToptal() throws Exception {

        // Step 2.2: Navigate to the Apply page
        DriverUtils.click(homePage.getApplyAsFreelancerLink());

        // Step 2.3: Set the type to "Designer" and fill in form fields
        DriverUtils.sendKeys(applyPage.getTypeDropdown(), "Designer");
        applyPage.fillForm("Ravikumar Anuma", "ravi.anuma@gmail.com", "Test@123");

        // Step 2.4: Confirm that the page contains the Submit button at the bottom
        WebElement submitWl = homePage.getApplyAsFreelancerLink();
        boolean submitButtonIsDisplay = DriverUtils.isDisplayed(submitWl);
        Assert.assertTrue(submitButtonIsDisplay, "submit Button is not Available in Webpage");

        // Step 2.5: Click on Submit button
        DriverUtils.click(applyPage.getSubmitButton());
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
