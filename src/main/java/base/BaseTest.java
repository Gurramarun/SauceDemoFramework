package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    // Using protected and non-static for better parallel execution support
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Selenium 4.x handles driver setup automatically via Selenium Manager
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // Use Duration (Selenium 4 standard) instead of long/TimeUnit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }
        
        if (driver != null) {
            driver.quit();
        }
    }

    private void captureScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Ensure the screenshots folder exists
            File targetDir = new File("target/screenshots");
            if (!targetDir.exists()) targetDir.mkdirs();
            
            FileHandler.copy(src, new File(targetDir + "/" + testName + ".png"));
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}