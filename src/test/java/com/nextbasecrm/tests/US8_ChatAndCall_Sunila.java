package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US8_ChatAndCall_Sunila {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @Test
    public void crm_login_test(){
        WebElement userLoginBtn = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLoginBtn.sendKeys("hr76@cybertekschool.com");

        WebElement userPasswordBtn = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPasswordBtn.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn.click();

    }
    @Test
    public void chat_and_call_module(){

        CRM_Utilities.crm_login(driver);

        WebElement chatAndCallModuleBtn = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        BrowserUtils.sleep(5);

        chatAndCallModuleBtn.click();
        BrowserUtils.sleep(5);

        WebElement notificationBtn = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-notify']"));
        System.out.println("notificationBtn.isDisplayed() = " + notificationBtn.isDisplayed());

        WebElement messageBtn = driver.findElement(By.xpath("//*[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im']"));
        System.out.println("messageBtn.isDisplayed() = " + messageBtn.isDisplayed());

        WebElement settingBtn = driver.findElement(By.xpath("//*[@class='bx-desktop-tab-icon bx-desktop-tab-icon-config']"));
        System.out.println("settingBtn.isDisplayed() = " + settingBtn.isDisplayed());

        WebElement activityStreamBtn = driver.findElement(By.xpath("//*[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im-lf']"));
        System.out.println("activityStreamBtn.isDisplayed() = " + activityStreamBtn.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }




}


