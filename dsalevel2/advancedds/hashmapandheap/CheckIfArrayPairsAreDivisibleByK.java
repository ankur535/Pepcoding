package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class CheckIfArrayPairsAreDivisibleByK {

	public static void solution(int[] arr, int k) {
		// write your code here

		//remainder frequency array
		int fre[] = new int[k];
		
		//iterate over the array and store the remainers with frequency
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			int rem = val % k;

			if (rem < 0) {
				rem += k;
			}

			//increase frequency at the rem index
			fre[rem]++;
		}

		//iterate over frequency array
		for (int rem = 0; rem <= k/2; rem++) {

			//rem as 0 and rem as mid value
			if (rem == 0 || rem == (k-rem)) {
				// if freq at rem 0 is not even
				if (fre[rem] % 2 != 0) {
					System.out.println("false");
					return;
				}
			} else {
				//if freq -> rem and freq -> k - rem not equal
				//means cannot form pair for 1 element
				if (fre[rem] != fre[k - rem]) {
					System.out.println("false");
					return;
				}
			}
		}
		System.out.println("true");
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr, k);
		scn.close();
	}

}
