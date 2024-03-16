package dsalevel2.bitmanipulation;

import java.util.*;

public class IsAPowerofTwo {

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    //write your code here

    //AND operation on bit of n and n-1 if 0, then power of 2 else not
    System.out.println(n > 0 && ((n & (n-1)) == 0 ? true: false));
  }

}