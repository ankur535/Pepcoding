package dsalevel1.advancedds.hashmapandheap;

import java.util.*;

public class GetCommonElements1 {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner in = new Scanner(System.in);

		int n1 = in.nextInt();
		int a1[] = new int[n1];

		for (int i = 0; i < n1; i++) {
			a1[i] = in.nextInt();
		}

		int n2 = in.nextInt();
		int a2[] = new int[n2];

		for (int i = 0; i < n2; i++) {
			a2[i] = in.nextInt();
		}

		in.close();

		// This is 2 map apprach, map1 for all array 1 values

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n1; i++) {

			int val = a1[i];
			map.put(val, 1);
		}

		// Iterate over the array 2 and check if map contains but map2 doesn't containt
		// then print it and store in map2

		HashMap<Integer, Integer> map2 = new HashMap<>();

		for (int i = 0; i < n2; i++) {

			int val2 = a2[i];

			if (map.containsKey(val2) && !map2.containsKey(val2)) {
				System.out.println(val2);
				map2.put(val2, 1);
			}
		}

	}

}