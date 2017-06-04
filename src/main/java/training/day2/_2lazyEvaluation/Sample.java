package training.day2._2lazyEvaluation;


import java.util.*;
import java.util.stream.*;

class Sample {                                       
  public static void main(String[] args) {           
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
    
    //Both imperative and functional perform same number of computations
    
    int result = 0;
                             
    for(int e : numbers) {
      if(isGT3(e) && isEven(e)) {
        result = doubleit(e);
        break;
      }
    }
    
    System.out.println(result);


    System.out.println(
      numbers.stream() //lazy evaluation
        .filter(Sample::isGT3)
        .filter(Sample::isEven)
        .map(Sample::doubleit)
        .findFirst()
        .orElse(0));                    
        
  }
  public static boolean isEven(int n) {
    System.out.println("isEven " + n);
    return n % 2 == 0;
  }

  public static boolean isGT3(int n) {
    System.out.println("isGT3 " + n);
    return n > 3;
  }

  public static int doubleit(int n) {
    System.out.println("doubleit " + n);
    return n * 2;
  }
}