package training.day2._2parallelization;
import java.util.*;
import java.util.stream.*;

class Sample {                                        
  public static void main(String[] args) {           
    Timeit.code(() -> findImperative(Tickers.symbols));
    
    Timeit.code(() -> findFunctional(Tickers.symbols.stream()));
    
    //To run the imperative code in parallel, we have to restructure the code.
    
    //To run the functional code in parallel, we just have to ask
    Timeit.code(() -> findFunctional(Tickers.symbols.parallelStream()));
    
   }

  //that's not going to make code any more readable or better.

  public static void findImperative(List<String> symbols) {
    List<StockInfo> stocks = new ArrayList<>();
    
    for(String symbol : symbols) {
      stocks.add(StockUtil.getPrice(symbol));
    }                                        
    
    List<StockInfo> stocksLT500 = new ArrayList<>();
    for(StockInfo stock : stocks) {
      if(StockUtil.isPriceLessThan(500).test(stock)) {
        stocksLT500.add(stock);
      }
    }
    
    StockInfo highPriced = new StockInfo("", 0.0);
    for(StockInfo stock : stocksLT500) {
      highPriced = StockUtil.pickHigh(stock, highPriced);
    }
    
    System.out.println(highPriced);
    
  }
  
  public static void findFunctional(Stream<String> symbols) {
    System.out.println(
      symbols.map(StockUtil::getPrice)
        .filter(StockUtil.isPriceLessThan(500))
        .reduce(new StockInfo("", 0.0), StockUtil::pickHigh));
  }
}





//The real question is, how can we make this concurrent. Tough luck, too much effort.