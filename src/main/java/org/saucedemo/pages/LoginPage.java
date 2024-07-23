package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    LoginPage loginPage;
    //Locators
    private By usernameFieldLocator = By.id("user-name");
    private By passwordFieldLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By loginPageTitleLocator = By.className("app_logo");

    //Constructor to initial the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameFieldLocator);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordFieldLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }


}
