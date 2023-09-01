package ch.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class App {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        // Handle the cookies popup (if present)
        try {
            WebElement agreeButton = driver.findElement(By.id("L2AGLb"));
            if (agreeButton.isDisplayed()) {
                agreeButton.click();
            }
        } catch (Exception e) {
            // Cookies popup not found or not visible, continue with the script
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("testing tool online org");
        searchBox.submit();

        // Wait for search results to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for page to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Capture a screenshot of a specific element (example: search box)
        WebElement elementToCapture = driver.findElement(By.name("q"));
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("element_screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Capture a screenshot of the full page
        File fullScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fullScreenshotFile, new File("fullpage_screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
