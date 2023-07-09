package tests.homepage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class HomePage extends TestBase {
    @Test
    public void Test(){
       WebElement mainPicture=  driver.findElement(By.cssSelector("a[href='https://demoqa.com']"));
       mainPicture.click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(mainPicture.isSelected());

        WebElement mainBanner= driver.findElement(By.xpath("//img[@class='banner-image']"));
        mainBanner.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(mainBanner.isEnabled());
    }
}
