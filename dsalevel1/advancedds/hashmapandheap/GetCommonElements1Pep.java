package dsalevel1.advancedds.hashmapandheap;

import java.util.*;

public class GetCommonElements1Pep {

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
		
		//This is single map apprach using remove method, map1 for all array 1 values
		
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n1; i++) {
			int key = a1[i];
			//update keys with same value if duplicate
			map.put(key, 1);
		}

		//Iterate over the array 2 and check if map contains then print it 
		//and remove that key
		
		for (int i = 0; i < n2; i++) {
			int key2 = a2[i];

			if (map.containsKey(key2)) {
				System.out.println(key2);
				map.remove(key2);
			}
		}
	}

}