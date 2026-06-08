package com.sdet.practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
//    private WebDriver driver;

//    @BeforeMethod
//    public void setUpDriver(){
//
//        driver = new ChromeDriver();
//
//        driver.get("https://www.saucedemo.com");
//    }


    @Test
    public void testLogin(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement((By.id("login-button"))).click();

        Assert.assertEquals(driver.getTitle(),"Swag Labs");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testInvalidLogin(){

        driver.findElement(By.id("user-name")).sendKeys("wrong_user");

        driver.findElement(By.id("password")).sendKeys("invalid_password");

        driver.findElement((By.id("login-button"))).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("[data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");

    }

//    @AfterMethod
//    public void closeDriver(){
//
////      driver.close(); // closes the current tab
//        driver.quit(); // closes the entire browser
//    }
}
