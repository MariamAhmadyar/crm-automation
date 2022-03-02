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

public class US4_Options_UnderUserProfile {
    WebDriver driver ;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void optionsHR() {

            WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
            username.sendKeys("hr76@cydeo.com");

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("UserUser");

            WebElement rememberMe = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
            rememberMe.click();

            WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
            logIn.click();

            WebElement userProfile = driver.findElement(By.xpath("//span[@class='user-name']"));
            userProfile.click();

            List<WebElement> elements = driver.findElements(By.xpath("//span[@class='menu-popup-item-text']"));

            for (WebElement element : elements) {
                Assert.assertTrue(element.isDisplayed());
            }

            WebElement logOut = driver.findElement(By.xpath("//span[.='Log out']"));
            Assert.assertTrue(logOut.isDisplayed());
            logOut.click();


    }

    @Test
    public void optionsHD(){
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("helpdesk77@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
        rememberMe.click();

        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        WebElement userProfile = driver.findElement(By.xpath("//span[@class='user-name']"));
        userProfile.click();

        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='menu-popup-item-text']"));

        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

        WebElement logOut = driver.findElement(By.xpath("//span[.='Log out']"));
        Assert.assertTrue(logOut.isDisplayed());
        logOut.click();
    }

    @Test
    public void optionsMarketing(){
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("marketing78@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
        rememberMe.click();

        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        WebElement userProfile = driver.findElement(By.xpath("//span[@class='user-name']"));
        userProfile.click();

        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='menu-popup-item-text']"));

        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

        WebElement logOut = driver.findElement(By.xpath("//span[.='Log out']"));
        Assert.assertTrue(logOut.isDisplayed());
        logOut.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }




}
