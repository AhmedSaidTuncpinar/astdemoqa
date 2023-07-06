package tests.elements;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class BrokenLinksAndImages extends TestBase {
    @Test
    public void Test(){
        driver.findElement(By.xpath("//span[text()='Broken Links - Images']")).click();

    }
}