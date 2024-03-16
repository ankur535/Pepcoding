package dsalevel2.bitmanipulation;

import java.util.*;

public class BasicsOfBitManipulation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();

		in.close();
		// write your code here
		
		//set ith bit
		System.out.println(n | (1 << i));		
		
		//unset jth bit
		int mask = 1 << j;
		System.out.println(n | (~mask));
		
		//toggle kth bit
		System.out.println(n ^ (1 << k));
		
		//know if bit is ON or OFF
		int res = n & (1 << m);
		System.out.println(res == 0 ? false : true);
	}

}