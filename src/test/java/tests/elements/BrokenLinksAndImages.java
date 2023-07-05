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
    public void testBrokenLinks() {
        driver.get("https://demoqa.com/broken");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String href = link.getAttribute("href");

            if (href != null && !href.isEmpty()) {
                HttpURLConnection connection = null;

                try {
                    connection = (HttpURLConnection) (new URL(href)).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println("Broken link: " + href);
                    }
                } catch (IOException e) {
                    System.out.println("Exception occurred while checking link: " + href);
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }
    }
}
