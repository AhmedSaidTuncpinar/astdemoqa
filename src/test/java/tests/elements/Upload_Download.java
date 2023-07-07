package tests.elements;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Upload_Download extends TestBase {

    @Test
    public void Test(){
        driver.findElement(By.xpath("//span[text()='Upload and Download']")).click();

         driver.findElement(By.xpath("//a[text()='Download']")).click();
         Thread.sleep(2000);

    }


}
