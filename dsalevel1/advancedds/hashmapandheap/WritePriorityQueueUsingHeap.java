package dsalevel1.advancedds.hashmapandheap;

import java.io.*;
import java.util.*;

public class WritePriorityQueueUsingHeap {

	public static class PriorityQueue {
		ArrayList<Integer> data;

		public PriorityQueue() {
			data = new ArrayList<>();
		}

		// Normal swap function
		public void swap(int i, int j) {

			int iele = data.get(i);
			int jele = data.get(j);

			data.set(i, jele);
			data.set(j, iele);
		}

		public void upHeapify(int ci) {

			if (ci == 0) {
				return;
			}

			// find parent index from child index
			int pi = (ci - 1) / 2;

			// if data at pi > data at ci, then swap as we need min at root and large
			// values at child, then call upHeapify for that parent also
			if (data.get(pi) > data.get(ci)) {
				swap(pi, ci);
				upHeapify(pi);
			}
		}

		public void add(int val) {
			// write your code here
			data.add(val);

			// upheafily with last index as new val added at last index of arraylist
			upHeapify(data.size() - 1);
		}

		public void downHeapify(int pi) {

			// left and right child index
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;

			int min_idx = pi;

			// if lci in range and element at lci smaller than element at minidx
			if (lci < data.size() && data.get(lci) < data.get(min_idx)) {
				min_idx = lci;
			}

			// if rci in range and element at rci smaller than element at minidx
			if (rci < data.size() && data.get(rci) < data.get(min_idx)) {
				min_idx = rci;
			}

			// if minidx is not same as pi, as set above
			// then swap parent and minimum child and call downheapify for that child
			// which now stores the parent
			if (min_idx != pi) {
				swap(pi, min_idx);
				downHeapify(min_idx);
			}

		}

		public int remove() {
			// write your code here
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}

			// store top/first min value
			int rv = data.get(0);
			// swap top and last value
			swap(0, data.size() - 1);
			// remove last node which stores top value after swapping
			data.remove(data.size() - 1);

			downHeapify(0);

			return rv;
		}

		public int peek() {
			// write your code here
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}

			return data.get(0);
		}

		public int size() {
			// write your code here
			return data.size();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue qu = new PriorityQueue();

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