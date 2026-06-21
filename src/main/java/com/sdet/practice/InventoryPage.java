package com.sdet.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By productTitles = By.cssSelector("[data-test='inventory-item-name']");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");

    private By sortButton = By.cssSelector(".product_sort_container");
    private By addProductToCart = By.cssSelector("button[data-test^='add-to-cart']");

    private By removeProductFromCart = By.cssSelector("button[data-test^='remove']");

    private By cartLink = By.cssSelector(".shopping_cart_link");

    private By footer = By.cssSelector(".footer-copy");

    private By continueShopping = By.cssSelector("#continue-shopping");

    private By inventoryItemDesc = By.cssSelector("div[data-test$='desc']");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    public int getProductCount(){

        List<WebElement> numberOfProducts = driver.findElements(productTitles);

        return numberOfProducts.size();
    }

    public List<String> getAllProductNames(){

        List<WebElement> elements = driver.findElements(productTitles);

        List<String> names = new ArrayList<>();

        for (WebElement element : elements) {

            names.add(element.getText());
        }

        return names;
    }

    public void addFirstProductToCart(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(addProductToCart));

        WebElement button = driver.findElement(addProductToCart);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

    }

    public String getCartCount(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

        return driver.findElement(cartBadge).getText();
    }

}


////    private List<WebElement> numberOfProducts = driver.findElements((By.cssSelector("[data-test='inventory-item-name']")));
//    private By inventoryPageTitle = By.xpath("//div[@class='header_label']/div[text()='Swag Labs']");
//
//    private By sauceLabsBackPackTitle = By.xpath("//div[@class='inventory_item_label']/a/div[text()='Sauce Labs Backpack']");
//
//    private By sauceLabsBikeLightTitle = By.xpath("//div[@class='inventory_item_label']/a/div[text()='Sauce Labs Bike Light']");
//
//    private By sauceLabsBoltTShirtTitle = By.xpath("//div[@class='inventory_item_label']/a/div[text()='Sauce Labs Bolt T-Shirt']");
//
//    private By sauceLabsFleeceJacketTitle = By.xpath("//div[@class='inventory_item_label']/a/div[text()='Sauce Labs Fleece Jacket']");
//
//    private By sauceLabsTestAllThingsRedShirtTitle = By.xpath("//div[@class='inventory_item_label']/a/div[text()='Test.allTheThings() T-Shirt (Red)']");
