package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9AccessCorrectModules_Ruth {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("env"));
    }

        //positive scenerio
        @Test
        public void login_with_valid_credentials_with_login_btn() {
            //Write username
            WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
            userName.sendKeys(ConfigurationReader.getProperty("username"));

            //Write password
            WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

            //Click login button
            WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
            BrowserUtils.sleep(2);
            loginBtn.click();

            //User is on homepage, clicks Drive module
            WebElement driveModule = driver.findElement(By.linkText("Drive"));
            BrowserUtils.sleep(2);
            driveModule.click();

            //Verify users see the correct title for the module
            String expectedTitle="Site map";
            String actualTitle=driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);

            driver.close();

        }
    }

