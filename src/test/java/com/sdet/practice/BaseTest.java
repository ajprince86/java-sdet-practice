package com.sdet.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void closeDriver(){

        driver.quit(); // closes the entire browser
    }


}
