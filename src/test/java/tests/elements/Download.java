package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Download extends TestBase {
    @Test
    public void Test() throws InterruptedException{
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("#item-7")).click();

        WebElement fileInput= driver.findElement(By.cssSelector("#uploadFile"));
        Thread.sleep(3000);
        String filePath1 = "/Users/ahmedsaidtuncpinar/Desktop/downloadFile.jpeg";
        Path path = Paths.get(filePath1);
        String absolutePath = path.toAbsolutePath().toString();

        // Enter the file path in the file input element
        fileInput.sendKeys(absolutePath);

        // Wait for the file to upload (adjust the duration if needed)
        Thread.sleep(3000);

        // Verify if the file is uploaded successfully
        WebElement uploadedFile = driver.findElement(By.id("uploadedFilePath"));
        String uploadedFilePath = uploadedFile.getText();

        String expectedFileName = "downloadFile.jpeg";
        String actualFileName = uploadedFilePath.substring(uploadedFilePath.lastIndexOf("\\") + 1);

        Assert.assertEquals("File names mismatch", expectedFileName, actualFileName);
    }
}
