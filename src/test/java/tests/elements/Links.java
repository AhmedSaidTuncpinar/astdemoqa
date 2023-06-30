package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class Links extends TestBase {
    @Test
    public void Test() throws InterruptedException {
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//span[text()='Links']")).click();

       String window1Text= driver.findElement(By.xpath("//a[@id='simpleLink']")).getText();
        Assert.assertEquals("DEMOQA",driver.getTitle());

        String window1Handle= driver.getWindowHandle();
        System.out.println(window1Handle);

        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();

        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String eachHandle:allWindowHandles){
            driver.switchTo().window(eachHandle);
        }
        String window2Handle=driver.getWindowHandle();
        Assert.assertEquals("DEMOQA",driver.getTitle());

        String window2Text=driver.findElement(By.xpath("//a[@id='dynamicLink']")).getText();
        Assert.assertEquals("DEMOQA",window2Text);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);

        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);


    }


}
