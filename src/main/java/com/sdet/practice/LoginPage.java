package com.sdet.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void login(String username, String password){

        driver.findElement(usernameInput).sendKeys(username);

        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(loginBtn).click();

    }
}
