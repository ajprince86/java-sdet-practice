package com.sdet.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;
    private  LoginPage loginPage;

    @BeforeMethod
    public void login() {

        loginPage = new LoginPage(driver);

        inventoryPage = new InventoryPage(driver);

        loginPage.login(config.getProperty("username"), config.getProperty("password"));
    }

    @Test
    public void verifyTotalProducts(){

        Assert.assertEquals(inventoryPage.getProductCount(),6);

    }

    @Test
    public void verifyCart(){

        inventoryPage.addFirstProductToCart();

        Assert.assertEquals(Integer.parseInt(inventoryPage.getCartCount()),1);

    }

}
