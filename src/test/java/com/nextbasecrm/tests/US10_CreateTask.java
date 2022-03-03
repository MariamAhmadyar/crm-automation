package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US10_CreateTask {


    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    // Users create tasks successfully
    //Environment:  https://login2.nextbasecrm.com/
    @Test
    public void Test_AC1(){
        driver.get(" https://login2.nextbasecrm.com/");

        // Enter login "hr76@cydeo.com"
        WebElement inputLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputLogin.sendKeys("hr76@cydeo.com");

        //Enter password"UserUser"

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        // click log in button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        // user is at homepage ,click TASK tab

        WebElement taskButton = driver.findElement(By.xpath("//span[.='Task']"));
        taskButton.click();

         //user write a task content
        //- passing index number of //*[@id="bx-component-scope-lifefeed_task_form"]/div/div[1]/div[1]/div[2]/input
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[1]/div[1]/div[2]/input"));
        yourContentGoesHereText.sendKeys("Hello");

        WebElement sendButton = driver.findElement(By.cssSelector("#blog-submit-button-save"));
        sendButton.click();

        WebElement streamResult = driver.findElement(By.xpath("//a[text() = 'Hello']"));
        Assert.assertEquals(streamResult.getText(), "Hello");
    }

    @Test
    public void Test_AC2(){

        // go to " https://login2.nextbasecrm.com/"

        driver.get(" https://login2.nextbasecrm.com/");
        //Calling my utility method to login helpdesk
        // Enter login "hr76@cydeo.com"
        WebElement inputLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputLogin.sendKeys("hr76@cydeo.com");

        //Enter password"UserUser"

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        // click log in button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();


        // user is at homepage ,click TASK tab

        WebElement taskButton = driver.findElement(By.xpath("//span[.='Task']"));
        taskButton.click();

       // WebElement sendButton = driver.findElement(By.xpath("//div//button[@id='blog-submit-button-save']"));
        //sendButton.click();
       WebElement sendButton = driver.findElement(By.cssSelector("#blog-submit-button-save"));
        sendButton.click();

        WebElement errorText = driver.findElement(By.xpath("//div[@class='task-message-label error']"));

        String actualText = driver.getTitle();
        String expectedText = "The task Name is not specified";
        
        Assert.assertEquals(actualText,expectedText);



    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}


