package org.saucedemo.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.saucedemo.pages.*;



public class StepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the Sauce Demo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        assert (driver.findElement(By.className("title")).isDisplayed());
    }

    @When("I add the first item to the cart")
    public void i_add_the_first_item_to_the_cart() {
        productsPage.addFirstItemToCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        productsPage.goToCartPage();
        cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("I fill in the checkout information with {string}, {string}, and {string}")
    public void i_fill_in_the_checkout_information_with_and(String firstName, String lastName, String postalCode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, postalCode);
        checkoutPage.clickContinueButton();
    }

    @When("I finish the checkout process")
    public void i_finish_the_checkout_process() {
        checkoutPage.clickFinishButton();
        confirmationPage = new ConfirmationPage(driver);
    }

    @Then("I should see the order confirmation message")
    public void i_should_see_the_order_confirmation_message() {
        assert (confirmationPage.isOrderConfirmationDisplayed());
    }
}
