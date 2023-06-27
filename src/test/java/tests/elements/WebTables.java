package tests.elements;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class WebTables extends TestBase {
    @Test
    public void Test() {
        Faker faker= new Faker();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement webTables= driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTables.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Task 1. Check Add button is clickable and verify it
        driver.findElement(By.cssSelector("button[id='addNewRecordButton']")).click();

        WebElement addButton= driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        Assert.assertTrue(addButton.isEnabled());

        //Task 2 Add new input by filling the registration page
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Mike");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Anderson");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("#age")).sendKeys("33");
        driver.findElement(By.cssSelector("#salary")).sendKeys("55000");
        driver.findElement(By.cssSelector("#department")).sendKeys("Project");
        driver.findElement(By.cssSelector("#submit")).click();


        //Verify new input is created
        WebElement newRecord=driver.findElement(By.xpath("//div[@class='ReactTable -striped -highlight']"));
        String newRecordText=newRecord.getText();

        Assert.assertTrue(newRecordText.contains("Mike"));
        Assert.assertTrue(newRecordText.contains("Anderson"));
        Assert.assertTrue(newRecordText.contains("33"));








    }
}
