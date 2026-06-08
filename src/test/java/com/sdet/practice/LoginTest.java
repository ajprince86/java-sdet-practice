package com.sdet.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");
    }


    @Test
    public void testLogin(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement((By.id("login-button"))).click();

        Assert.assertEquals(driver.getTitle(),"Swag Labs");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }

    @AfterMethod
    public void closeDriver(){

//      driver.close(); // closes the current tab
        driver.quit(); // closes the entire browser
    }
}
