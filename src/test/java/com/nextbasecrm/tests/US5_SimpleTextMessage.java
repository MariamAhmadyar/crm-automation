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

public class US5_SimpleTextMessage {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void userSendSimpleMessage() {

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("hr76@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
        rememberMe.click();

        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        WebElement crm = driver.findElement(By.xpath("//span[.='Send message …']"));
        crm.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement message = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        message.sendKeys("Hello Cydeo");

        driver.switchTo().parentFrame();
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
    }

    @Test
    public void warningMessage() {

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("hr76@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
        rememberMe.click();

        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        WebElement crm = driver.findElement(By.xpath("//span[.='Send message …']"));
        crm.click();

        driver.switchTo().parentFrame();
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();

        WebElement errormessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));

        Assert.assertTrue(errormessage.isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
