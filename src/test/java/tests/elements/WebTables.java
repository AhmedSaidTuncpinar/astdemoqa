package tests.elements;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class WebTables extends TestBase {
    @Test
    public void Test() {
        Faker faker= new Faker();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.findElement(By.xpath("(//span[@class='text'])[4]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Task 1. Check Add button is clickable and verify it
        driver.findElement(By.cssSelector("button[id='addNewRecordButton']")).click();

        WebElement addButton= driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        Assert.assertTrue(addButton.isEnabled());


    }
}
