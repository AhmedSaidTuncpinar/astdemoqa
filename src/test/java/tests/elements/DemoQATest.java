package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class DemoQATest extends TestBase {
    @Test
    public void testAllFeatures() {


        // Find and click on the "Toolsqa" link
       driver.findElement(By.xpath("//a[@href='https://demoqa.com']")).click();
        WebElement toolsqa= driver.findElement(By.xpath("//img[@class='banner-image']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(toolsqa.isDisplayed());

        // Verify the expected page title for the "Toolsqa" feature
       /* String expectedToolsqaPageTitle = "DEMOQA";
        String actualToolsqaPageTitle = driver.getTitle();
        Assert.assertEquals(expectedToolsqaPageTitle, actualToolsqaPageTitle);*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Go back to the main page


        // Find and click on the "Elements" link
        driver.findElement(By.xpath("//h5[.='Elements']")).click();
        // Verify the expected page title for the "Elements" feature
        String expectedElementsPageUrl = "https://demoqa.com/elements";
        String actualElementsPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedElementsPageUrl, actualElementsPageUrl);

        // Go back to the main page
        driver.navigate().back();

        // Find and click on the "Forms" link
        driver.findElement(By.xpath("//h5[text()='Forms']")).click();
        // Verify the expected page title for the "Forms" feature
        String expectedFormsPageUrl = "https://demoqa.com/forms";
        String actualFormsPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedFormsPageUrl, actualFormsPageUrl);

        // Go back to the main page
        driver.navigate().back();

        // Find and click on the "Alerts" link
        driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
        // Verify the expected page title for the "Alerts" feature
        String expectedAlertsPageUrl = "https://demoqa.com/alertsWindows";
        String actualAlertsPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedAlertsPageUrl, actualAlertsPageUrl);

        // Go back to the main page
        driver.navigate().back();


    }
}