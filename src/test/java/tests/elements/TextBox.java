package tests.elements;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.time.Duration;

public class TextBox extends TestBase {

    @Test
    public void Test(){
        Faker faker= new Faker();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[.='Text Box']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='userName']")).sendKeys(faker.name().fullName());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys(faker.internet().emailAddress());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(faker.address().fullAddress());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='permanentAddress']")).sendKeys(faker.address().fullAddress());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='submit']")).click();

       //Verifications
        //Verify the webpage is reachable
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://demoqa.com/text-box";
        Assert.assertEquals("Failed",expectedUrl,actualUrl);

    }
}
