import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class BtcMediaScraper extends AbstractScraper{
    @Override
    public List<String> scrape() {
        List<String> headlines = new LinkedList<>();
        driver.get("https://bits.media/bitcoin/");
        List<WebElement> elements = driver.findElements(By.xpath("//h2[@class='news-name']"));
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
