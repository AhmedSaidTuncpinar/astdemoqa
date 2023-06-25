package tests.elements;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.time.Duration;

public class WebTables extends TestBase {
    @Test
    public void Test() {
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[.='Elements']")).click();
        driver.findElement(By.xpath("(//span[@class='text'])[4]"));
        //Task 1. Print the entire table
        System.out.println("PRINT ENTIRE TABLE***");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String entireTable= driver.findElement(By.xpath("//div[@class='web-tables-wrapper']")).getText();
        System.out.println(entireTable);

    }
}
