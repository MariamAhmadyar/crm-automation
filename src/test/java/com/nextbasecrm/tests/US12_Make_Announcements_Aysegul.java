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

public class US12_Make_Announcements_Aysegul {
    WebDriver driver;

    @BeforeMethod
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //login
        driver.get("https://login2.nextbasecrm.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Enter username
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("hr76@cydeo.com");
        //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");
        //Click login
        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

    }

    @Test
    public void make_announcement() {

        WebElement moreBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreBtn.click();

        WebElement clickAnnouncementTab =
                driver.findElement(By.xpath("//div[@id='popup-window-content-menu-popup-feed-add-post-form-popup']/div/div/span[3]/span[2]"));

        clickAnnouncementTab.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement textMessage = driver.findElement(By.xpath("//body"));
        textMessage.sendKeys("Testing the announcement");

        driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

    }

    @Test
    public void make_announcement_withoutContent()  {
        WebElement moreBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreBtn.click();

        WebElement clickAnnouncementTab = driver.findElement(By.xpath("//div[@id='popup-window-content-menu-popup-feed-add-post-form-popup']/div/div/span[3]/span[2]"));
        clickAnnouncementTab.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement textMessage = driver.findElement(By.xpath("//body"));
        textMessage.sendKeys(" ");

        driver.switchTo().parentFrame();
        WebElement empty = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        empty.click();

        WebElement warningMessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
       // Assert.assertEquals(warningMessage.getText(), "The message title is not specified", "The title doesn't match");
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

// hr76@cydeo.com	helpdesk76@cydeo.com	marketing76@cydeo.com
//Story 12:
//As a user, I should be able to Make Announcements using the Announcements tab.
//AC:
//1. Users should be able to write messages in and send announcements by clicking the SEND button.
//2. When users attempt to make announcements without a message, there should be a working message “The message title is not specified”.
//
//Test cases #1
//Description:  Users make Announcements successfully
//Environment:  https://login2.nextbasecrm.com/
//Steps:: Users are on the homepage
//            Users click MORE tab and select ANNOUNCEMENTS
//            Users write announcements message
//    Users click the SEND button
//           Verify the announcements is displayed on the feed
//Test cases #2
//Description:  Users create announcements without content
//Environment:  https://login2.nextbasecrm.com/
//Steps::Users are on the homepage
//            Users click MORE tab and select ANNOUNCEMENT
//    Users click the SEND button
//           Verify “The message title is not specified” warning message is displayed on the page
