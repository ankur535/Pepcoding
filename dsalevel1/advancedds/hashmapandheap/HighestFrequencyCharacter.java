package dsalevel1.advancedds.hashmapandheap;

import java.util.*;

public class HighestFrequencyCharacter {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			// if key already exists, increase its count
			if (map.containsKey(ch)) {
				int freq = map.get(ch);
				map.put(ch, freq + 1);
			} else {
				// else put new key with count 1
				map.put(ch, 1);
			}
		}

		int max_freq = 0;
		char ans = ' ';

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			// finding frequenc of character
			int freq = map.get(ch);

			// if freq is greater, it will become max_freq and take that character;
			if (freq > max_freq) {
				max_freq = freq;
				ans = ch;
			}
		}

		System.out.println(ans);

		/*
		 * Or this can be done
		 * 
		 * Character ch = null; for (Character key : map.keySet()) {
		 * 
		 * if (max < map.get(key)) { max = map.get(key); ch = key; } }
		 */

	}
	
	/* Efficient Solution
	 
	 public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String str = in.nextLine();
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		char ch = ' ';
		int count = 0;
		
		for (char c: str.toCharArray()) {
			
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			} else {
				hm.put(c, 1);
			}
			
			if (hm.get(c) > count) {
				ch = c;
				count = hm.get(c);
			}
		}
		
		System.out.println(ch);
		
	}
	 */
}
