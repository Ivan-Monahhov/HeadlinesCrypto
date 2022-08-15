import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class CoinsPaidMediaScraper extends AbstractScraper{

    @Override
    public List<String> scrape() {
        List<String> headlines = new LinkedList<>();
        driver.get("https://coinspaidmedia.com/ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='news-feed__item']")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='news-feed__item']"));
        elements.forEach(webElement -> {
            String headline = webElement.getText();
            ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(headline);
            headline = new String(byteBuffer.array(),StandardCharsets.UTF_8);
            headlines.add(headline);
        });
        driver.close();
        return headlines;
    }
}
