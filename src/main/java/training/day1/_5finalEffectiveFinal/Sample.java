package training.day1._5finalEffectiveFinal;

import java.util.*;

class Sample {                                       
  public static void main(String[] args) {           
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    
    numbers.stream()
      .map(e -> e * 2) 
      .forEach(System.out::println);
      
    int factor = 2; 
    
    numbers.stream()
      .map(e -> e * factor) 
      .forEach(System.out::println);           
      
  }
}