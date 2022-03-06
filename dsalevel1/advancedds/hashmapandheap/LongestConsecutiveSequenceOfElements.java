package dsalevel1.advancedds.hashmapandheap;

import java.util.*;

public class LongestConsecutiveSequenceOfElements {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		in.close();

		HashSet<Integer> set = new HashSet<>();

		//fill unique values, set store only unique values and ignores duplicates
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			set.add(key);
		}

		//starting point for longest sequencce and length of sequence
		int start = -1;
		int max_len = 0;

		for (Integer key : set) {

			//if set doesn't containt previous number as key
			if (!set.contains(key-1)) {
				
				int count = 1;

				//find length of sequence for that starting point
				while (set.contains(key + count)) {
					count++;
				}

				//if lenght of sequence is more than previous sequence, replace it
				if (count > max_len) {
					max_len = count;
					start = key;
				}
			}
		}

		//print sequnce from starting point till length
		for (int i = 0; i < max_len; i++) {
			System.out.println(start + i);
		}
	}
}
