package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class US6_MoreTabFunc_Siham {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void TC1_login_with_valid_credentials_helpdesk() throws InterruptedException {

        // Step 1 - User go to https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

        // Step 2 - Enter login "helpdesk78@cydeo.com"
        WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginInput.sendKeys("helpdesk78@cydeo.com");

        // Step 3 - Enter password "UserUser"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

        // Step 4 - Press Login button
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

        Thread.sleep(5000);

        // Step 5 - User clicks MORE tab at home page
        WebElement MoreButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']//span[@id='feed-add-post-form-link-more']/span[.='More']"));
        MoreButton.click();

        // Step 6 - Locate options in MORE tab
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='menu-popup-item-text']"));

        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

        // Step 7 log out of website
        WebElement logOutButton = driver.findElement(By.xpath("//span[@class='menu-popup-item-text']"));
        logOutButton.click();
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}

            




