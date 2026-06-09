package com.sdet.practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        Assert.assertEquals(driver.getTitle(),"Swag Labs");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testInvalidLogin(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user","invalid_password");

        Assert.assertEquals(driver.findElement(By.cssSelector("[data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");

    }

//    @AfterMethod
//    public void closeDriver(){
//
////      driver.close(); // closes the current tab
//        driver.quit(); // closes the entire browser
//    }
}


//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//
//        driver.findElement((By.id("login-button"))).click();


//        loginPage.login("standard_user","secret_sauce");

//    private WebDriver driver;

//    @BeforeMethod
//    public void setUpDriver(){
//
//        driver = new ChromeDriver();
//
//        driver.get("https://www.saucedemo.com");
//    }
//        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
//
//        driver.findElement(By.id("password")).sendKeys("invalid_password");
//
//        driver.findElement((By.id("login-button"))).click();