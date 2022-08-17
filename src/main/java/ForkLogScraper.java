import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ForkLogScraper extends AbstractScraper{
    @Override
    public List<String> scrape() {
        Set<String> headlines = new HashSet<>();
        driver.get("https://forklog.com/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='text_blk']"));
        elements.forEach(webElement -> {
            String headline = webElement.getText();
            ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(headline);
            headline = new String(byteBuffer.array(),StandardCharsets.UTF_8);
            headlines.add(headline);
        });
        driver.close();
        return headlines.stream().toList();
    }
}
