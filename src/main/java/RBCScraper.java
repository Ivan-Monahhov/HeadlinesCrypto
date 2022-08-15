import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class RBCScraper extends AbstractScraper {
    @Override
    public List<String> scrape() {
        List<String> headlines = new LinkedList<>();
        driver.get("https://www.rbc.ru/crypto/currency/btcusd");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='item js-currency-item']"));
        elements.forEach(webElement -> {
            String headline = webElement.getText();
            byte[] bytes = headline.getBytes(StandardCharsets.UTF_8);
            headline = new String(bytes);
            headlines.add(headline);
        });
        driver.close();
        return headlines;
    }
}
