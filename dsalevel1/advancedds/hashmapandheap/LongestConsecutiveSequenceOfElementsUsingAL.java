package dsalevel1.advancedds.hashmapandheap;

import java.util.*;

public class LongestConsecutiveSequenceOfElementsUsingAL {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner scn = new Scanner(System.in);

		int n1 = scn.nextInt();
		int[] a1 = new int[n1];
		for (int i = 0; i < n1; i++) {
			a1[i] = scn.nextInt();
		}
		scn.close();

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < n1; i++) {
			if (!al.contains(a1[i])) {
				al.add(a1[i]);
			}
		}

		Collections.sort(al);

		//Using 4 pointers technique and keeping start and end of longest consequence
		int start = 0;
		int end = 0;
		int ni = 0;
		int k = 1;
		int count = 1;
		int maxcount = 1;

		while (k < al.size()) {

			if (al.get(k) - al.get(k - 1) == 1) {
				count++;
			} else if (count > maxcount) {
				start = ni;
				end = k - 1;
				ni = k;
				maxcount = count;
				count = 1;
			} else {
				ni = k;
				count = 1;
			}
			k++;
		}

		if (maxcount < count) {
			start = ni;
			end = k - 1;
		}

		for (int i = start; i <= end; i++) {
			System.out.println(al.get(i));
		}
	}
}
