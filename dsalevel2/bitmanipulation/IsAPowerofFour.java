package dsalevel2.bitmanipulation;

import java.util.*;

public class IsAPowerofFour {

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    //write your code here

    //Power of 4 should be power of 2 and (n-1) should be divisible by 3
    
    boolean power2 = n > 0  && (n & (n-1)) == 0 ? true : false;
    
    boolean power4 = power2 && (n-1)%3 == 0;  
    
    System.out.println(power4);
  }

}