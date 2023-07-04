package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class Links extends TestBase {
    @Test
    public void Test() throws InterruptedException {
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//span[text()='Links']")).click();

        // Click on the first window link to open a new window

       WebElement firstWindowLink= driver.findElement(By.xpath("//a[@id='simpleLink']"));
       firstWindowLink.click();
        // Get the window handles
        Set<String> windowHandles=driver.getWindowHandles();
        // Switch to the new window
        String mainWindowHandle= driver.getWindowHandle();
        for (String handle:windowHandles){
            if (!handle.equals(mainWindowHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }
        // Perform actions in the new window (e.g., print the URL)
        System.out.println("New Window URL: " + driver.getCurrentUrl());
        // Close the new window
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        // Find the element for the second window link and click
       WebElement secondWindowLink= driver.findElement(By.cssSelector("#dynamicLink"));
        secondWindowLink.click();
        // Get the window handles again
        windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Perform actions in the new window (e.g., print the URL)
        System.out.println("New Window URL: " + driver.getCurrentUrl());

        // Close the new window
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

       WebElement createdLink= driver.findElement(By.cssSelector("#created"));
       createdLink.click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       WebElement responseCreated= driver.findElement(By.cssSelector("#linkResponse"));
       String textOfCreated= responseCreated.getText();
        Assert.assertTrue(textOfCreated.contains("Link has responded"));
    }
    }

