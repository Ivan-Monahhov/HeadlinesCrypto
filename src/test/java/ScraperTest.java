import org.junit.jupiter.api.Test;

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

}
