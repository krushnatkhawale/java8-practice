package training.day2._2parallelization;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class YahooFinance {
  public static double getPrice(final String ticker) {
    try {
      final URL url = 
        new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + ticker + "&f=snd1l1yr");
      final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      reader.lines().forEach(System.out::println);
      final String data = reader.lines().limit(1).findFirst().get();
      final String[] dataItems = data.split(",");
      double price = Double.parseDouble(dataItems[dataItems.length - 1]);      
      return price;
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}