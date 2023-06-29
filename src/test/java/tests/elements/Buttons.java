package tests.elements;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;

public class Buttons extends TestBase {
    @Test
    public void Test(){
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//span[.='Buttons']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Actions actions= new Actions(driver);

        WebElement doubleClickBtn=driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());

        WebElement rightClickButton= driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement clickMe=driver.findElement(By.xpath("//button[@id='tfSEN']"));
        actions.click(clickMe).perform();
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());



    }

}
