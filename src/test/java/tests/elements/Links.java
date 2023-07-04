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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement noContentLink=driver.findElement(By.cssSelector("#no-content"));
        noContentLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement noContentResponse= driver.findElement(By.xpath("//b[text()='No Content']"));
        String textOfNoContent= noContentResponse.getText();
        Assert.assertTrue(textOfNoContent.contains("No Content"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement movedLink=driver.findElement(By.cssSelector("#moved"));
        movedLink.click();
        WebElement movedResponse=driver.findElement(By.xpath("//b[text()='Moved Permanently']"));
        String textOfMoved=movedResponse.getText();
        Assert.assertTrue(textOfMoved.contains("Moved Permanently"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement badRequestLink=driver.findElement(By.cssSelector("#bad-request"));
        badRequestLink.click();
        WebElement badRequestResponse=driver.findElement(By.xpath("//a[text()='Bad Request']"));
        String textOfBadRequest =badRequestResponse.getText();
        Assert.assertTrue(textOfBadRequest.contains("Bad Request"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement unauthorizedLink= driver.findElement(By.cssSelector("#unauthorized"));
        unauthorizedLink.click();
        WebElement unauthorizedResponse=driver.findElement(By.xpath("//a[text()='Unauthorized']"));
        String textOfUnauthorized=unauthorizedResponse.getText();
        Assert.assertTrue(textOfUnauthorized.contains("Unauthorized"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement forbiddenLink= driver.findElement(By.cssSelector("#forbidden"));
        forbiddenLink.click();
        WebElement forbiddenResponse=driver.findElement(By.xpath("//a[text()='Forbidden']"));
        String textOfForbidden=forbiddenResponse.getText();
        Assert.assertTrue(textOfForbidden.contains("Forbidden"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement notFoundLink= driver.findElement(By.cssSelector("#invalid-url"));
        notFoundLink.click();
        WebElement notFoundResponse=driver.findElement(By.xpath("//a[text()='Not Found']"));
        String textOfNotFound=notFoundResponse.getText();
        Assert.assertTrue(textOfNotFound.contains("Not Found"));

    }
    }

