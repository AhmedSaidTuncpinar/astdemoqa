package tests.home_page;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;
import java.time.Duration;

public class DemoQATest extends TestBase {
    @Test
    public void testAllFeatures() throws InterruptedException {
        // Find and click on the "Toolsqa" link
       driver.findElement(By.xpath("//a[@href='https://demoqa.com']")).click();
        WebElement toolsqa= driver.findElement(By.xpath("//img[@class='banner-image']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(toolsqa.isDisplayed());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));



        // Find and click on the "Elements" link
       driver.findElement(By.xpath("//h5[.='Elements']")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

       WebElement elementHeader= driver.findElement(By.xpath("//div[@class='main-header']"));
       Assert.assertTrue(elementHeader.isDisplayed());


        // Go back to the main page
        driver.navigate().back();

        // Find and click on the "Forms" link
        driver.findElement(By.xpath("//h5[text()='Forms']")).click();
        // Verify the expected page title for the "Forms" feature
        WebElement elementForms= driver.findElement(By.xpath("(//div[text()='Forms'])[1]"));
        Assert.assertTrue(elementForms.isDisplayed());

        // Go back to the main page
        driver.navigate().back();

        // Find and click on the "Alerts" link
        driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
        // Verify the expected page title for the "Alerts" feature
       WebElement elementAlert= driver.findElement(By.xpath("(//div[text()='Alerts, Frame & Windows'])[1]"));
       Assert.assertTrue(elementAlert.isDisplayed());

        // Go back to the main page
        driver.navigate().back();

        driver.findElement(By.xpath("//h5[.='Widgets']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement elementWidgets=driver.findElement(By.xpath("(//div[text()='Widgets'])[1]"));
        Assert.assertTrue(elementWidgets.isDisplayed());

        driver.navigate().back();
        driver.findElement(By.xpath("//h5[.='Interactions']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement elementInteractions= driver.findElement(By.xpath("(//div[text()='Interactions'])[1]"));
        Assert.assertTrue(elementInteractions.isDisplayed());



        driver.navigate().back();

        WebElement webelementBook=driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", webelementBook);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement elementBook= driver.findElement(By.xpath("(//div[text()='Book Store'])[1]"));
        Assert.assertTrue(elementBook.isDisplayed());
    }
}