package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    ProductsPage productsPage;

    private By firstItemAddToCartButtonLocator = By.className("btn_inventory");
    private  By cartIconLocator = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver){
        LoginPage loginPage;
        this.driver=driver;
    }

    public void addFirstItemToCart(){
        driver.findElement(firstItemAddToCartButtonLocator).click();
    }

    public void goToCartPage(){
        driver.findElement(cartIconLocator).click();
    }
}
