package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Upload_Download extends TestBase {

    @Test
    public void Test() throws InterruptedException {
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("#item-7")).click();

        driver.findElement(By.xpath("//a[text()='Download']")).click();

        Thread.sleep(3000); // Wait for the download to complete (adjust the duration if needed)

        String filePath = "/Users/ahmedsaidtuncpinar/Downloads/sampleFile.jpeg";

        boolean isDownloaded = Files.exists(Paths.get(filePath));
        System.out.println(isDownloaded);

        Assert.assertTrue("File not downloaded", isDownloaded);


    }
}



