package training.day2._1functionComposition;

import java.util.Arrays;
import java.util.List;

class Sample {                                       
  public static void main(String[] args) {           
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
    
    //find the double of the first even number greater than 3.
    
    int result = 0;
                             
    
    System.out.println(result);


    System.out.println(
        //.findFirst()
        //.orElse(0)
    );
  }
  
  
  
  
  
  
  
  
  
  
  
  public static boolean isEven(int n) {
    return n % 2 == 0;
  }

  public static boolean isGT3(int n) {
    return n > 3;
  }

  public static int doubleit(int n) {
    return n * 2;
  }
}