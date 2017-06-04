package training.day2._2parallelization;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class YahooFinance {
  public static double getPrice(final String ticker) {
    try {
      final URL url = 
        new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + ticker + "&f=snl1");
      final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      final String data = reader.lines()
    		  .map(line -> { return line.replace("\",", "\",,");})
    		  .findFirst().get();
      final String[] dataItems = data.split(",,");
      double price = Double.parseDouble(dataItems[2]);      
      return price;
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}