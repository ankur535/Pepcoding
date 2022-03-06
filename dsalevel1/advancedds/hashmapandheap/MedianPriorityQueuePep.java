package dsalevel1.advancedds.hashmapandheap;

import java.io.*;
import java.util.*;

public class MedianPriorityQueuePep {

	public static class MedianPriorityQueue {
		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;

		public MedianPriorityQueue() {
			left = new PriorityQueue<>(Collections.reverseOrder());
			right = new PriorityQueue<>();
		}

		public void add(int val) {
			// write your code here
			// if right has element and its val is greater than
			// right peek, then add in right
			if (right.size() > 0 && val > right.peek()) {
				right.add(val);
			} else {
				// if val is less than right peek or right doesn't have
				// any element add in left
				left.add(val);
			}

			// balance left and right
			// if left has extra element, put in right
			if (left.size() - right.size() == 2) {
				right.add(left.remove());
			} else if (right.size() - left.size() == 2) {
				// if right has extra element, put in left
				left.add(right.remove());
			}

		}

		public int remove() {
			// write your code here
			if (left.size() == 0 && right.size() == 0) {
				// no element, print underflow
				System.out.println("Underflow");
				return -1;
			} else if (right.size() > left.size()) {
				// right has more element, so median is right peek, remove it
				return right.remove();
			} else {
				// if left and right has same element
				// or left has more element then
				// left peek is the median, so remove it
				return left.remove();
			}
		}

		public int peek() {
			// write your code here
			if (left.size() == 0 && right.size() == 0) {
				System.out.println("Underflow");
				return -1;
			} else if (right.size() > left.size()) {
				// right has more element, so median is right peek
				return right.peek();
			} else {
				// if left and right has same element
				// or left has more element then
				// left peek is the median
				return left.peek();
			}
		}

		public int size() {
			// write your code here
			return left.size() + right.size();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MedianPriorityQueue qu = new MedianPriorityQueue();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("add")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				qu.add(val);
			} else if (str.startsWith("remove")) {
				int val = qu.remove();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("peek")) {
				int val = qu.peek();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(qu.size());
			}
			str = br.readLine();
		}
	}
}