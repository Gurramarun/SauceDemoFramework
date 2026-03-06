package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        // Wait for Finish button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finish = wait.until(
                ExpectedConditions.elementToBeClickable(finishBtn)
        );

        finish.click();
    }
}