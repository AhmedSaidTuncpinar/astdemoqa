package tests.elements;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class TextBox extends TestBase {

    @Test
    public void Test(){
        Faker faker= new Faker();

        driver.findElement(By.xpath("//h5[.='Elements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//span[.='Text Box']")).click();
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

        //Verify "Elements" feature is clickable
        WebElement elements= driver.findElement(By.xpath("//*[.='Elements']"));
        Assert.assertTrue("The elements is not clickable",elements.isDisplayed());
        Assert.assertTrue("The elements is not clickable", elements.isEnabled());

        //Verify "Text Box option is clickable

        WebElement textBox= driver.findElement(By.xpath("//*[.='Text Box']"));
        Assert.assertTrue("The text box is not clickable",textBox.isEnabled());

        //Verify "Full Name" is displayed
        WebElement fullName= driver.findElement(By.xpath("//*[@id='userName']"));
        Assert.assertTrue("The full name is not displayed", fullName.isDisplayed());

        //Verify "Email" is displayed
        WebElement email= driver.findElement(By.xpath("//*[@id='userEmail']"));
        Assert.assertTrue("Email is displayed", email.isDisplayed());
    }
}
