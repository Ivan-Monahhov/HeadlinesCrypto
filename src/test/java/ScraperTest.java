import com.opencsv.CSVWriter;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ScraperTest {
    @Test
    public void RBC(){
        RBCScraper scraper = new RBCScraper();
        List<String> headlines = scraper.scrape();
        System.out.println(headlines);
    }
    @Test
    public void forkLog(){
        ForkLogScraper scraper = new ForkLogScraper();

        List<String> headlines = scraper.scrape();
        System.out.println(headlines);
    }
    @Test
    public void BTCMedia(){
        BtcMediaScraper scraper = new BtcMediaScraper();

        List<String> headlines = scraper.scrape();
        System.out.println(headlines);
    }
    @Test
    public void BitNovosti(){
        BitNovostiScraper scraper = new BitNovostiScraper();

        List<String> headlines = scraper.scrape();
        System.out.println(headlines);
    }
    @Test
    public void cryptoNews(){
        CryptoNewsScraper scraper = new CryptoNewsScraper();

        List<String> headlines = scraper.scrape();
        System.out.println(headlines);
    }
    @Test
    public void coinsPaidMedia(){
        CoinsPaidMediaScraper scraper = new CoinsPaidMediaScraper();

        List<String> headlines = scraper.scrape();
        System.out.println(headlines);
    }

    @Test
    public void allTest(){
        List<String> headlines = new LinkedList<>();
        AbstractScraper scraper = new RBCScraper();
        headlines.addAll(scraper.scrape());
        scraper = new ForkLogScraper();
        headlines.addAll(scraper.scrape());
        scraper = new BtcMediaScraper();
        headlines.addAll(scraper.scrape());
        scraper = new BitNovostiScraper();
        headlines.addAll(scraper.scrape());
        scraper = new CryptoNewsScraper();
        headlines.addAll(scraper.scrape());
        scraper = new CoinsPaidMediaScraper();
        headlines.addAll(scraper.scrape());


        System.out.println(headlines);
        try {
            writeLineByLine(headlines, Path.of("headlines.csv"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeLineByLine(List<String> lines, Path path) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            for (String line : lines) {
                String[] l = {line};
                writer.writeNext(l);
            }
        }
    }

    /*public String writeLineByLine(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            for (String[] line : lines) {
                writer.writeNext(line);
            }
        }
    */
}
