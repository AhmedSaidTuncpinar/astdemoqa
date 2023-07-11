package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class MainPage extends TestBase {
    @Test
    public void mainPage(){
     WebElement mainHead= driver.findElement(By.xpath("//a[@href='https://demoqa.com']"));
     mainHead.click();
        Assert.assertTrue(mainHead.isEnabled());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement bannerImage= driver.findElement(By.xpath("//img[@class='banner-image']"));
        bannerImage.click();
        Assert.assertTrue(bannerImage.isEnabled());

        WebElement mainElement= driver.findElement(By.xpath("//*[.='Elements']"));
        mainElement.click();
        Assert.assertTrue(mainElement.isEnabled());

        WebElement forms= driver.findElement(By.xpath("//h5[text()='Forms']"));
        forms.click();
        Assert.assertTrue(forms.isEnabled());

    }

}
