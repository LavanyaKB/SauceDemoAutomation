package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;

    private By orderConfirmationMessage = By.className("complete-header");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderConfirmationDisplayed() {
        return driver.findElement(orderConfirmationMessage).isDisplayed();
    }
}
