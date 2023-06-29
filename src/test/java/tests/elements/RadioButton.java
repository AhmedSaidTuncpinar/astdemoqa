package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class RadioButton extends TestBase {

    @Test
    public void Test(){



        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("(//span[@class='text'])[3]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement yesRadioButton= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveRadioButton= driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noRadioButton= driver.findElement(By.xpath("//label[@for='noRadio']"));

        yesRadioButton.click();

        Assert.assertTrue(yesRadioButton.isEnabled());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        impressiveRadioButton.click();
        Assert.assertFalse(impressiveRadioButton.isSelected());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        noRadioButton.isSelected();
        Assert.assertFalse(noRadioButton.isSelected());

    }
}
