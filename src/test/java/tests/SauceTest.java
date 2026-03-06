package tests;

import base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceTest extends BaseTest {

    @Test(priority = 1)
    public void validLogin() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 2)
    public void addProductToCart() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addProductToCart();
        products.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Test(priority = 3)
    public void completeCheckout() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addProductToCart();
        products.openCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout();

        Assert.assertTrue(driver.getPageSource().contains("Thank you"));
    }
}