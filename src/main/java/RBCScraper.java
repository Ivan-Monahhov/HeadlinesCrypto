import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RBCScraper extends AbstractScraper {
    @Override
    public List<String> scrape() {
        Set<String> headlines = new HashSet<>();
        driver.get("https://www.rbc.ru/crypto/currency/btcusd");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='item js-currency-item']"));
        elements.forEach(webElement -> {
            String headline = webElement.getText();
            byte[] bytes = headline.getBytes(StandardCharsets.UTF_8);
            headline = new String(bytes);
            headlines.add(headline);
        });
        driver.close();
        return headlines.stream().toList();
    }
}
