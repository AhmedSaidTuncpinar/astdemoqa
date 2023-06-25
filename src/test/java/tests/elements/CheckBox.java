package tests.elements;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class CheckBox extends TestBase {
    @Test
    public void Test(){
        Faker faker= new Faker();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//span[.='Check Box']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


      // WebElement homeCheckBox=  driver.findElement(By.xpath("//span[@class='rct-checkbox']"));

       driver.findElement(By.xpath("//button[@aria-label='Expand all']")).click();

       WebElement desktopCheckBox= driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[2]"));
       WebElement documentCheckBox= driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[5]"));
       WebElement downloadChcekBox= driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[15]"));

       boolean isDesktopCheckBox= desktopCheckBox.isEnabled();
       boolean isDocumentCheckbox= documentCheckBox.isEnabled();
       boolean isDownloadCheckbox= downloadChcekBox.isEnabled();

        Assert.assertTrue("The 'Desktop' checkbox is not clickable",isDesktopCheckBox);
        Assert.assertTrue("The 'Document' checkbox is clickable",isDocumentCheckbox);
        Assert.assertTrue("The Download checkbox is clickable", isDownloadCheckbox);
    }
}
