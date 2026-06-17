package com.sdet.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @BeforeMethod
    public void login() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(config.getProperty("username"), config.getProperty("password"));
    }

    @Test
    public void verifyTotalProducts(){

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertEquals(inventoryPage.getProductCount(),6);

    }


}
