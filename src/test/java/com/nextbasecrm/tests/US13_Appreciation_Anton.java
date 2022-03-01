package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US13_Appreciation_Anton {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test_AC1() throws InterruptedException {

        //2. Go to https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

        //3. Enter login "hr78@cydeo.com"
        WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginInput.sendKeys("hr78@cydeo.com");

        //Enter password "UserUser"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

        //press Log In button
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

        Thread.sleep(2000);

        //User is at homepage, clicks MORE tab
        WebElement MoreButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']//span[@id='feed-add-post-form-link-more']/span[.='More']"));
        MoreButton.click();

        //User clicks Appreciation from the dropdown menu
        WebElement AppreciationButton = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Appreciation']"));
        AppreciationButton.click();

        //User writes the message
        driver.switchTo().frame(0);
        WebElement AppreciationBodyText = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        AppreciationBodyText.sendKeys("Testing the wooden spoon");
        System.out.println("AppreciationBodyText.getText() = " + AppreciationBodyText.getText());

        driver.switchTo().parentFrame();


        //Click SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();


    }


    @Test
    public void test_AC2() throws InterruptedException {

        //2. Go to https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

        //3. Enter login "hr78@cydeo.com"
        WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginInput.sendKeys("hr78@cydeo.com");

        //Enter password "UserUser"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

        //press Log In button
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

        Thread.sleep(2000);

        //User is at homepage, clicks MORE tab
        WebElement MoreButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']//span[@id='feed-add-post-form-link-more']/span[.='More']"));
        MoreButton.click();

        //User clicks Appreciation from the dropdown menu
        WebElement AppreciationButton = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Appreciation']"));
        AppreciationButton.click();

        //Click SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //Making sure the "The message title is not specified" warning is displayed
        WebElement warningText = driver.findElement(By.xpath("//span[.='The message title is not specified']"));

        String expectedWarningText = "The message title is not specified";
        String actualWarningText = warningText.getText();

        Assert.assertEquals(actualWarningText, expectedWarningText);

        if(actualWarningText.equals(expectedWarningText)){
            System.out.println("The warning is displayed correctly.");
        }else{
            System.out.println("The warning is displayed INCORRECTLY!");
        }
    }

@AfterMethod
    public void teardownMethod(){
        driver.close();
}


}


