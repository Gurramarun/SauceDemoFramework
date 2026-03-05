package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstProduct = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartIcon = By.className("shopping_cart_link");

    public void addProduct() {
        driver.findElement(firstProduct).click();
        driver.findElement(cartIcon).click();
    }
}