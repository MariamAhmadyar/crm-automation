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

public class US14_DesktopOptionsVisibilityCheck_Anton {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testMethod() throws InterruptedException {

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

        //check to see if the 3 buttons are there for MAC OS, WINDOWS and LINUX
        WebElement macButton = driver.findElement(By.xpath("//span[.='Mac OS']"));
        WebElement windowsButton = driver.findElement(By.xpath("//span[.='Windows']"));
        WebElement linuxButton = driver.findElement(By.xpath("//span[.='Linux']"));

        String expectedMacButtonText = "MAC OS";
        String expectedWindowsButtonText = "WINDOWS";
        String expectedLinuxButtonText = "LINUX";

        String actualMacButtonText = macButton.getText();
        String actualWindowsButtonText = windowsButton.getText();
        String actualLinuxButtonText = linuxButton.getText();

        System.out.println("macButton.getText() = " + macButton.getText());
        System.out.println("windowsButton.getText() = " + windowsButton.getText());
        System.out.println("linuxButton.getText() = " + linuxButton.getText());


        if (expectedMacButtonText.equals(actualMacButtonText)) {
            System.out.println("Mac OS button test passed");
        } else {
            System.out.println("Mac OS button test FAILED!!!");
        }

        if (expectedWindowsButtonText.equals(actualWindowsButtonText)) {
            System.out.println("Windows button test passed");
        } else {
            System.out.println("Windows button test FAILED!!!");
        }

        if (expectedLinuxButtonText.equals(actualLinuxButtonText)) {
            System.out.println("Linux button test passed");
        } else {
            System.out.println("Linux button test FAILED!!!");
        }


    }


    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }


}
