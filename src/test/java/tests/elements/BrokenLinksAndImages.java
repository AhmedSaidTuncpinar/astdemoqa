package tests.elements;

import org.junit.Assert;
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
    public void testBrokenLinks() throws IOException {
        driver.get("https://demoqa.com/broken");

        // Check anchor links
        int brokenLinkCount = checkLinks(By.tagName("a"), "href");
        Assert.assertEquals("Number of broken links", 1, brokenLinkCount);
    }

    @Test
    public void testBrokenImages() throws IOException {
        driver.get("https://demoqa.com/broken");

        // Check image links
        int brokenImageCount = checkLinks(By.tagName("img"), "src");
        Assert.assertEquals("Number of broken images", 0, brokenImageCount);
    }

    private int checkLinks(By locator, String attribute) throws IOException {
        int brokenCount = 0;

        for (WebElement element : driver.findElements(locator)) {
            String link = element.getAttribute(attribute);

            if (link != null && !link.isEmpty()) {
                HttpURLConnection connection = null;

                try {
                    URL url = new URL(link);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println("Broken " + attribute + ": " + link);
                        brokenCount++;
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }

        return brokenCount;
    }
}