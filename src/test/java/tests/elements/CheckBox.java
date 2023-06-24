package tests.elements;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
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
    }
}
