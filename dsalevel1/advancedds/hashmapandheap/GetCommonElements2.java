package dsalevel1.advancedds.hashmapandheap;

import java.util.*;

public class GetCommonElements2 {

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

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n1; i++) {
			int key = a1[i];

			// put key with frequency of that number
			if (map.containsKey(key)) {
				int old_freq = map.get(key);
				map.put(key, old_freq + 1);
			} else {
				map.put(key, 1);
			}
		}

		for (int i = 0; i < n2; i++) {

			int key2 = a2[i];

			// if map contains that value
			if (map.containsKey(key2)) {
				int freq = map.get(key2);
				// if freq is greater than 0 means it is part of intersection
				// once freq becomes 0, it is outside of intersection
				if (freq > 0) {
					System.out.println(key2);
				}

				map.put(key2, freq - 1);
			}
		}
	}
}