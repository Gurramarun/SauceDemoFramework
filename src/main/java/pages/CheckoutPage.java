package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public void completeCheckout() {

        // Open cart
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

        // Checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();

        // Fill details
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Arun");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(postalCode).sendKeys("500001");

        // Continue
        driver.findElement(continueBtn).click();

        // Finish order
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }
}