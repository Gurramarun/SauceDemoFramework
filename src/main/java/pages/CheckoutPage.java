package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public void completeCheckout() {
        driver.findElement(checkoutBtn).click();
        driver.findElement(firstName).sendKeys("Arun");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(postalCode).sendKeys("500001");
        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();
    }
}