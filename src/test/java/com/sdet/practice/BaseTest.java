package com.sdet.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
public class BaseTest {
    protected ConfigManager config = new ConfigManager();
    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

        driver.get(config.getProperty("base.url"));
    }

    @AfterMethod
    public void closeDriver(){

        driver.quit(); // closes the entire browser
    }

}


//      driver.get("https://www.saucedemo.com");
