package com.nextbasecrm.tests;


import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US3_LogOut_From_NextBaseCRM_Elvin {
    WebDriver driver;

    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/stream/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void saveCredentials() {
        setup();
        String credential1[] = {"hr76@cydeo.com", "hr77@cydeo.com", "hr78@cydeo.com",
                "helpdesk76@cydeo.com", "helpdesk77@cydeo.com", "helpdesk78@cydeo.com", "marketing76@cydeo.com",
                "marketing77@cydeo.com", "marketing78@cydeo.com"};

        String credential2 = "CydeoCydeo";

        for (int i = 0; i < credential1.length; i++) {
            setup();

            WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            username.sendKeys(credential1[i]);

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("UserUser");


            WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
            System.out.println("CREDENTIALS - " + "\n" + "USER ID: " + credential1[i] + "\n" + "PASSWORD: " +
                    credential2 + "\nIS REMEMBER ME DISPLAYED: " + rememberMeCheckbox.isDisplayed());

            rememberMeCheckbox.click();
            rememberMeCheckbox.isSelected();

            WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
            loginButton.click();

            WebElement userProfile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
            userProfile.click();

            WebElement logout = driver.findElement(By.xpath("//span[@class='menu-popup-item-text']"));
            logout.click();

            driver.close();
        }
    }
}
    /* DATA:   "hr76@cydeo.com", "hr77@cydeo.com", "hr78@cydeo.com",
    "helpdesk76@cydeo.com", "helpdesk77@cydeo.com", "helpdesk78@cydeo.com",
    "marketing76@cydeo.com","marketing77@cydeo.com", "marketing78@cydeo.com"

 */